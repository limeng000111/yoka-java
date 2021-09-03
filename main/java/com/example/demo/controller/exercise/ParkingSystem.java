package com.example.demo.controller.exercise;

public class ParkingSystem {
    int a,b,c;
    public ParkingSystem(int big,int medium,int small){
        a = big;
        b = medium;
        c = small;
    }

    public boolean addCar(int carType){
        if (carType == 1){
            if (a < 0){
                return false;
            }
            a--;
        }

        if (carType == 2){
            if (b < 1){
                return false;
            }
            b--;
        }

        if (carType == 3){
            if (c < 1){
                return false;
            }
            c--;
        }

        return true;
    }
}
