/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concretebridgecostestimatorneuralnetwork;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.DataSetRow;

/**
 *
 * @author Nuwan Prabhath
 */
public class Normalizer {
    
    static double normalizeInput(double min, double max, double input) {
        return (input - min) / (max - min);
    }

    static double deNormalize(NeuralNetwork nnet, DataSetRow test, double min, double max) {
        nnet.setInput(test.getInput());
        nnet.calculate();

        double[] networkOutput = nnet.getOutput();
        double result = networkOutput[0];
        System.out.println("NN result "+result+" min: "+min+", max:"+max+" last"+result * (max - min));

        return min + result * (max - min);
    } 
    
}
