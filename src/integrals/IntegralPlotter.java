package integrals;
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
import java.util.ArrayList;
import java.util.Collections;


// Java 8 code

public class IntegralPlotter extends Application {
	
	private static ArrayList<Double> integralPointsY = new ArrayList<Double>();
	private static ArrayList<Double> integralPointsX = new ArrayList<Double>();
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage stage) {
		plotIntegral(stage);
		
	}

	private void plotIntegral( Stage stage) {
			double xAxisMax = Collections.max(integralPointsX);
			double xAxisMin = Collections.min(integralPointsX);
			double yAxisMax=Collections.max(integralPointsY);
			double yAxisMin=Collections.min(integralPointsY);

		Axes axes = new Axes(
				500, 350,
				(xAxisMin-xAxisMin*.5), (xAxisMax+xAxisMax*.5), integralPointsX.get(0)*0.2,
				yAxisMin-yAxisMin*.25, (yAxisMax+yAxisMax*.25), yAxisMax*0.1
				);



		Plot plot = new Plot(xAxisMin, xAxisMax,axes);

		StackPane layout = new StackPane(
				plot
				);
		layout.setPadding(new Insets(20));
		layout.setStyle("-fx-background-color: rgb(35, 39, 50);");

		stage.setTitle("Simpsons Rule");
		this.setSceneEvents(plot);
		stage.setScene(new Scene(layout, Color.rgb(35, 39, 50)));
		stage.show();
		
//	
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
				double xMin, double xMax,
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
			
			
			path.getElements().add(
					new MoveTo(
							mapX(integralPointsX.get(0), axes), mapY(integralPointsY.get(0), axes)
							)
					);
			
			
			for(int x=1;x<integralPointsY.size();x++){

				
				path.getElements().add(
						new LineTo(
								mapX(integralPointsX.get(x), axes), mapY(integralPointsY.get(x), axes)
								)
						);

				
				
			}

			setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
			setPrefSize(axes.getPrefWidth(), axes.getPrefHeight());
			setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);

			getChildren().setAll(axes, path);
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


	public static ArrayList<Double> getIntegralPointsY() {
		return integralPointsY;
	}

	public static void setIntegralPointsY(ArrayList<Double> integralPointsY) {
		IntegralPlotter.integralPointsY = integralPointsY;
	}

	public static ArrayList<Double> getIntegralPointsX() {
		return integralPointsX;
	}

	public static void setIntegralPointsX(ArrayList<Double> integralPointsX) {
		IntegralPlotter.integralPointsX = integralPointsX;
	}
	


	
}