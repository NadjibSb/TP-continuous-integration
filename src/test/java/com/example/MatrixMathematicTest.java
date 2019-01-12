package com.example;


import com.example.exception.NoSquareException;
import com.example.model.Matrix;
import com.example.service.MatrixMathematics;
import org.junit.Assert;
import org.junit.Test;


public class MatrixMathematicTest {

    /*
    @Test
    public void transpose() {
        double[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] dataT = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};

        Matrix M = new Matrix(data);
        Matrix T = new Matrix(dataT);

        for (int j = 0; j < data.length; j++) {
            Assert.assertArrayEquals(T.getValues()[j], MatrixMathematics.transpose(M).getValues()[j], 0);
        }
    }


    @Test
    public void inverse() throws NoSquareException {
        double[][] data = {{2, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] dataI = {{1, -2, 1}, {-2, 1, 0}, {1, 2 / 3, -2 / 3}};

        Matrix M = new Matrix(data);
        Matrix I = new Matrix(dataI);

        for (int j = 0; j < data.length; j++) {
            Assert.assertArrayEquals(I.getValues()[j], MatrixMathematics.inverse(M).getValues()[j], 1);
        }
    }

    @Test(expected = NoSquareException.class)
    public void inverse2() throws NoSquareException {
        double[][] data = {{1, 2, 3}, {4, 5, 6}};
        Matrix M = new Matrix(data);

        MatrixMathematics.inverse(M);
    }
    */
    @Test
    public void determinant() throws NoSquareException {

        double[][] data = {{2, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix M = new Matrix(data);
        double det = -3;

        Assert.assertEquals(MatrixMathematics.determinant(M), det, 0);
    }

    @Test(expected = NoSquareException.class)
    public void determinant2() throws NoSquareException {
        double[][] data = {{1, 2, 3}, {4, 5, 6}};
        Matrix M = new Matrix(data);

        MatrixMathematics.determinant(M);
    }

    @Test
    public void cofactor() throws NoSquareException {
        double[][] data = {{2, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] dataC = {{-3, 6, -3}, {6, -3, -2}, {-3, 0, 2}};

        Matrix M = new Matrix(data);
        Matrix C = new Matrix(dataC);

        for (int j = 0; j < data.length; j++) {
            Assert.assertArrayEquals(C.getValues()[j], MatrixMathematics.cofactor(M).getValues()[j], 0);
        }
    }

    @Test(expected = NoSquareException.class)
    public void cofactor2() throws NoSquareException {
        double[][] data = {{1, 2, 3}, {4, 5, 6}};
        Matrix M = new Matrix(data);

        MatrixMathematics.cofactor(M);
    }

    @Test
    public void createSubMatrix() {
        double[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] dataS = {{1, 3}, {7, 9}};

        Matrix M = new Matrix(data);
        Matrix S = new Matrix(dataS);

        for (int j = 0; j < data.length-1; j++) {
            Assert.assertArrayEquals(S.getValues()[j], MatrixMathematics.createSubMatrix(M, 1, 1).getValues()[j], 0);
        }
    }


}