package entities;

import java.util.Arrays;

import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.util.TransferFunctionType;

public class PerceptronMultiCapa 
{
	private DataSet trainingSet;
	private MultiLayerPerceptron myMlPerceptron;

	public PerceptronMultiCapa()
	{
		trainingSet = new DataSet(2,1);
		trainingSet.addRow(new DataSetRow(new double[]{7,2}, new double[]{1}));
		trainingSet.addRow(new DataSetRow(new double[]{8,3}, new double[]{1}));
		trainingSet.addRow(new DataSetRow(new double[]{9,4,}, new double[]{1}));
		trainingSet.addRow(new DataSetRow(new double[]{10,5}, new double[]{1}));
		trainingSet.addRow(new DataSetRow(new double[]{11,6}, new double[]{1}));
		trainingSet.addRow(new DataSetRow(new double[]{12,3}, new double[]{1}));
		trainingSet.addRow(new DataSetRow(new double[]{12,5}, new double[]{0}));
		trainingSet.addRow(new DataSetRow(new double[]{13,3}, new double[]{0}));
		trainingSet.addRow(new DataSetRow(new double[]{13,10}, new double[]{1}));
		trainingSet.addRow(new DataSetRow(new double[]{14,2}, new double[]{0}));
		trainingSet.addRow(new DataSetRow(new double[]{14,7}, new double[]{1}));
		trainingSet.addRow(new DataSetRow(new double[]{15,3}, new double[]{0}));
		trainingSet.addRow(new DataSetRow(new double[]{15,8}, new double[]{1}));
		trainingSet.addRow(new DataSetRow(new double[]{16,4}, new double[]{0}));
		trainingSet.addRow(new DataSetRow(new double[]{16,9}, new double[]{1}));
		trainingSet.addRow(new DataSetRow(new double[]{17,5}, new double[]{0}));
		trainingSet.addRow(new DataSetRow(new double[]{17,11}, new double[]{0}));

		myMlPerceptron = new MultiLayerPerceptron(TransferFunctionType.TANH, 2, 3, 1);
	}

	public void aprender()
	{
		myMlPerceptron.learn(trainingSet);
		myMlPerceptron.save("aprendizaje.nnets");
	}

	public void testNeuralNetwork() 
	{
		for(DataSetRow dataRow : trainingSet.getRows()) {

			myMlPerceptron.setInput(dataRow.getInput());
			myMlPerceptron.calculate();
			double[ ] networkOutput = myMlPerceptron.getOutput();
			System.out.print("Input: " + Arrays.toString(dataRow.getInput()) );
			System.out.println(" Output: " + Arrays.toString(networkOutput) ); 

		}
	}

	public DataSet getTrainingSet() {
		return trainingSet;
	}

	public void setTrainingSet(DataSet trainingSet) {
		this.trainingSet = trainingSet;
	}

	public MultiLayerPerceptron getMyMlPerceptron() {
		return myMlPerceptron;
	}

	public void setMyMlPerceptron(MultiLayerPerceptron myMlPerceptron) {
		this.myMlPerceptron = myMlPerceptron;
	}
}