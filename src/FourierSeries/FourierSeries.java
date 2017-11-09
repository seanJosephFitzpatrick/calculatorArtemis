package FourierSeries;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.ScrollEvent;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.util.Duration;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.input.MouseButton;

import javafx.scene.input.MouseEvent;
import java.util.Scanner;
import java.util.function.Function;




public class FourierSeries extends Application {
	private static String waveform;
	private static double period;
	private static int harmonic;
	private static String mode;
	private static double amplitude;
	private static double phase;
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage stage) {
	
		if(mode.equalsIgnoreCase("Fourier Series")){
		plotFourierSeriesofWaveform(stage);
		}
		else{
		plotUserDefinedWaveform( stage);	
		}
	}

	private void plotUserDefinedWaveform( Stage stage) {
		// TODO Auto-generated method stub


		Axes axes = new Axes(
				500, 350,
				-(period+period*.5), (period+period*.5), period*0.2,
				-(10), (10), 1
				);



		Plot plot = new Plot(
				phase,period,amplitude,
				-(period+period*.5), (period+period*.5), period*0.01,
				axes
				);

		StackPane layout = new StackPane(
				plot
				);
		layout.setPadding(new Insets(20));
		layout.setStyle("-fx-background-color: rgb(35, 39, 50);");

		stage.setTitle("Fourier Series");
		this.setSceneEvents(plot);
		stage.setScene(new Scene(layout, Color.rgb(35, 39, 50)));
		stage.show();
		
	
		}

	private void plotFourierSeriesofWaveform( Stage stage) {


		Axes axes = new Axes(
				500, 350,
				-(period+period*.5), (period+period*.5), period*0.2,
				-6, 6, 1
				);



		Plot plot = new Plot(
				harmonic,period,waveform,
				-(period+period*.5), (period+period*.5), period*0.01,
				axes
				);

		StackPane layout = new StackPane(
				plot
				);
		layout.setPadding(new Insets(20));
		layout.setStyle("-fx-background-color: rgb(35, 39, 50);");

		stage.setTitle("Fourier Series");
		this.setSceneEvents(plot);
		stage.setScene(new Scene(layout, Color.rgb(35, 39, 50)));
		stage.show();
	}

	public static String getMode() {
		return mode;
	}

	public static void setMode(String mode) {
		FourierSeries.mode = mode;
	}

	class Axes extends Pane {
		private NumberAxis xAxis;
		private NumberAxis yAxis;

		public Axes(
				int width, int height,
				double xLow, double xHi, double xTickUnit,
				double yLow, double yHi, double yTickUnit
				) {
			setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
			setPrefSize(width, height);
			setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);

			xAxis = new NumberAxis("Time s: ",xLow, xHi, xTickUnit);
			xAxis.setSide(Side.BOTTOM);
			xAxis.setMinorTickVisible(false);
			xAxis.setPrefWidth(width);
			xAxis.setLayoutY(height / 2);

			yAxis = new NumberAxis("Amplitude V: ",yLow, yHi, yTickUnit);
			yAxis.setSide(Side.LEFT);
			yAxis.setMinorTickVisible(false);
			yAxis.setPrefHeight(height);
			yAxis.layoutXProperty().bind(
					Bindings.subtract(
							(width / 2) + 1,
							yAxis.widthProperty()
							)
					);

			getChildren().setAll(xAxis, yAxis);
		}

		public NumberAxis getXAxis() {
			return xAxis;
		}

		public NumberAxis getYAxis() {
			return yAxis;
		}
	}

	class Plot extends Pane {
		public Plot(
				int harmonic,double period,String waveform,
				double xMin, double xMax, double xInc,
				Axes axes
				) {
			Path path = new Path();
			path.setStroke(Color.ORANGE.deriveColor(0, 1, 1, 0.6));
			path.setStrokeWidth(1.5);

			path.setClip(
					new Rectangle(
							0, 0, 
							axes.getPrefWidth(), 
							axes.getPrefHeight()
							)
					);

			double x = xMin;
			double y = 0;

			y=generateYCoordinates(harmonic,period,waveform,x);
			path.getElements().add(
					new MoveTo(
							mapX(x, axes), mapY(y, axes)
							)
					);
			y=0;
			x += xInc;
			while (x < xMax) {

				y=generateYCoordinates(harmonic,period,waveform,x);
				path.getElements().add(
						new LineTo(
								mapX(x, axes), mapY(y, axes)
								)
						);

				x += xInc;
				y=0;
			}

			setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
			setPrefSize(axes.getPrefWidth(), axes.getPrefHeight());
			setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);

			getChildren().setAll(axes, path);
		}

		public Plot(double phase, double period, double amplitude, double xMin, double xMax, double xInc, Axes axes) {
			// TODO Auto-generated constructor stub
			{
				Path path = new Path();
				path.setStroke(Color.ORANGE.deriveColor(0, 1, 1, 0.6));
				path.setStrokeWidth(1.5);

				path.setClip(
						new Rectangle(
								0, 0, 
								axes.getPrefWidth(), 
								axes.getPrefHeight()
								)
						);

				double x = xMin;
				double y = 0;

				y=generateYCoordinates(phase,period,amplitude,x);
				path.getElements().add(
						new MoveTo(
								mapX(x, axes), mapY(y, axes)
								)
						);
				y=0;
				x += xInc;
				while (x < xMax) {

					y=generateYCoordinates(phase,period,amplitude,x);
					path.getElements().add(
							new LineTo(
									mapX(x, axes), mapY(y, axes)
									)
							);

					x += xInc;
					y=0;
				}

				setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
				setPrefSize(axes.getPrefWidth(), axes.getPrefHeight());
				setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);

				getChildren().setAll(axes, path);
			}
		}

		private double generateYCoordinates(double phase, double period, double amplitude, double x) {
			// TODO Auto-generated method stub
			double y=0;
			y=amplitude*Math.sin(2*Math.PI*(1/period)*x+(phase*(Math.PI/180)));
			return y;
			
		}

		private double generateYCoordinates(int harmonic, double period, String waveform, double x) {
			double y=0;
			
			if(waveform.equalsIgnoreCase("square")){
				for(int har=1;har<=harmonic;har+=2)
					{
						y=y+(6/(Math.PI*har))*(Math.sin(x*(1/period)*2*Math.PI*har));

					}
			}
			else if(waveform.equalsIgnoreCase("triangle")){
				for(int har=1;har<=harmonic;har+=2)
					{
						y=y+(8/(Math.pow(Math.PI, 2)))*(Math.cos(x*(1/period)*2*Math.PI*har)/(Math.pow(har, 2)));
		
					}
			}
			else{
				for(int har=1;har<=harmonic;har++){
					y=y+(Math.pow(1, har+1)*2)*(Math.sin(x*(1/period)*2*Math.PI*har)/(har));

				}
			}
			
			
			
			return y;
		}

		private double mapX(double x, Axes axes) {
			double tx = axes.getPrefWidth() / 2;
			double sx = axes.getPrefWidth() / 
					(axes.getXAxis().getUpperBound() - 
							axes.getXAxis().getLowerBound());

		
			return x * sx + tx;
		}

		private double mapY(double y, Axes axes) {
			double ty = axes.getPrefHeight() / 2;
			double sy = axes.getPrefHeight() / 
					(axes.getYAxis().getUpperBound() - 
							axes.getYAxis().getLowerBound());
			return -y * sy + ty;
		}

		public void setPivot(double x,double y,double zoomFactor) {
			// TODO Auto-generated method stub
			Timeline timeline = new Timeline(60);
			DoubleProperty myScale = new SimpleDoubleProperty(1.0);

			timeline.getKeyFrames().clear();
			timeline.getKeyFrames().addAll(
					new KeyFrame(Duration.millis(200), new KeyValue(translateXProperty(), getTranslateX() - x)),
					new KeyFrame(Duration.millis(200), new KeyValue(translateYProperty(), getTranslateY() - y)),
					new KeyFrame(Duration.millis(200), new KeyValue(myScale, zoomFactor))
					);
			timeline.play();

		}
		public void resetZoom () {
			double scale = 1.0d;

			double x = getTranslateX();
			double y = getTranslateY();

			setPivot(x, y, scale);
		}
		 public void fitWidth () {
	            double scale = getParent().getLayoutBounds().getMaxX()/getLayoutBounds().getMaxX();
	            double oldScale = 1.0;

	            double f = scale - oldScale;

	            double dx = getTranslateX() - getBoundsInParent().getMinX() - getBoundsInParent().getWidth()/2;
	            double dy = getTranslateY() - getBoundsInParent().getMinY() - getBoundsInParent().getHeight()/2;

	            double newX = f*dx + getBoundsInParent().getMinX();
	            double newY = f*dy + getBoundsInParent().getMinY();

	            setPivot(newX, newY, scale);

	        }
	}


	private void setSceneEvents(final Plot plot) {
		//handles mouse scrolling
		DragContext dragContext = new DragContext();
	
		
		plot.setOnScroll(
				new EventHandler<ScrollEvent>() {
					@Override
					public void handle(ScrollEvent event) {
						// double zoomFactor = 1.05;
						double deltaY = event.getDeltaY();
						//                    if (deltaY < 0){
						//                      zoomFactor = 2.0 - zoomFactor;
						//                    }
						double zoomFactor = 1.0;
						if (deltaY < 0) {
							zoomFactor /= 1.3d;
						} else {
							zoomFactor *= 1.3d;
						}
						//double  mousePositionX = event.getX();
						//double mousePositionY = event.getY();
						double  mousePositionX = (event.getX()-(plot.getBoundsInParent().getWidth()/2 + plot.getBoundsInParent().getMinX()));
						double mousePositionY = (event.getY()- (plot.getBoundsInParent().getHeight()/2 + plot.getBoundsInParent().getMinY()));
						double f = (zoomFactor / 1.0)-1;
						plot.setPivot(f*mousePositionX,f*mousePositionY,zoomFactor);
						plot.setScaleX(plot.getScaleX() * zoomFactor);
						plot.setScaleY(plot.getScaleY() * zoomFactor);
						event.consume();
					}
				});
		plot.setOnMouseClicked(
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getButton().equals(MouseButton.PRIMARY)) {
							if (event.getClickCount() == 2) {
								plot.resetZoom();
							} 
						}
						if (event.getButton().equals(MouseButton.SECONDARY)) {
		                    if (event.getClickCount() == 2) {
		                        plot.fitWidth();
		                    }
		                }
					}
				});
		plot.setOnMousePressed(
				new EventHandler<MouseEvent>() {
			@Override
            public void handle(MouseEvent event) {

                 dragContext.mouseAnchorX = event.getX();
                 dragContext.mouseAnchorY = event.getY();

                dragContext.translateAnchorX = plot.getTranslateX();
                dragContext.translateAnchorY = plot.getTranslateY();

            }

        });
		plot.setOnMouseDragged(
				new EventHandler<MouseEvent>() {
			@Override
            public void handle(MouseEvent event) {

				plot.setTranslateX(dragContext.translateAnchorX + event.getX() - dragContext.mouseAnchorX);
                plot.setTranslateY(dragContext.translateAnchorY + event.getY() - dragContext.mouseAnchorY);

                event.consume();

            }

        });
	}
	class DragContext {

        double mouseAnchorX;
        double mouseAnchorY;

        double translateAnchorX;
        double translateAnchorY;

    }


	public static String getWaveform() {
		return waveform;
	}

	public static void setWaveform(String waveform) {
		FourierSeries.waveform = waveform;
	}

	public static double getPeriod() {
		return period;
	}

	public static void setPeriod(double period) {
		FourierSeries.period = period;
	}

	public static int getHarmonic() {
		return harmonic;
	}

	public static void setHarmonic(int harmonic) {
		FourierSeries.harmonic = harmonic;
	}

	public static double getAmplitude() {
		return amplitude;
	}

	public static void setAmplitude(double amplitude) {
		FourierSeries.amplitude = amplitude;
	}

	public static double getPhase() {
		return phase;
	}

	public static void setPhase(double phase) {
		FourierSeries.phase = phase;
	}
	
	
	
}