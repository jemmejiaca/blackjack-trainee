package entities;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.UIManager;

import org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel;
import org.neuroph.nnet.MultiLayerPerceptron;

import view.Window;

public class Main 
{
	/*public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try
        		{
        			JFrame.setDefaultLookAndFeelDecorated(true);
        			UIManager.setLookAndFeel(new SubstanceMistAquaLookAndFeel());
        		}
        		catch(Exception e)
        		{
        			e.printStackTrace();
        		}
        		
				
				try 
				{
					Window frame = new Window();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		PerceptronMultiCapa lel = new PerceptronMultiCapa();
		System.out.println("Empezaremos a aprender");
		lel.aprender();
		lel.testNeuralNetwork();
//		System.out.println("testing para verficiar que funciona");
//		lel.setMyMlPerceptron((MultiLayerPerceptron) MultiLayerPerceptron.load(new FileInputStream(new File("aprendizaje.nnets"))));
//		lel.getMyMlPerceptron().setInput(17,10);
//		lel.getMyMlPerceptron().calculate();
//		//System.out.println(lel.getMyMlPerceptron().getOutput());
//		
//		double[] networkOutput = lel.getMyMlPerceptron().getOutput();
//		for (int i = 0; i < networkOutput.length; i++) {
//			System.out.println(networkOutput[i]);
//		}
	}
}
