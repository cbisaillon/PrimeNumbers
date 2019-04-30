package com.math;

import java.util.ArrayList;

/**
 * Un programme donnant les facteurs premiers d'un nombre entre 2 et 1000 inclusivement
 * @author Clement Bisaillon et Leonard Oest O'Leary
 */
public class FacteurPremier {

    public static void main(String[] args) {
        System.out.println(getNombresPremiersSous(1000).size());
    }

    /**
     * Utilisé pour avoir tous les nombres premiers entre 2 et max
     * @param max limite des nombres premiers trouvés
     * @return la liste des nombres premiers plus petits que max
     */
    private static ArrayList<Integer> getNombresPremiersSous(int max){
        ArrayList<Integer> allNumbersArray = new ArrayList<>();
        //Commencer par populer la liste avec tous les nombres
        for(int i = 2 ; i < max + 1 ; i++){
            allNumbersArray.add(i);
        }

        ArrayList<Integer> listOfPrimes = new ArrayList<>();

        //Deux est premier. Le mettre dans la liste des nombres premiers et l'enlever de l'autre array
        listOfPrimes.add(2);
        allNumbersArray.remove(2);

        //Ajoute succecivement les nombres premiers trouvés dans la liste des nombres premiers
        for(int i = 0 ; i < allNumbersArray.size() ; i++){
            int nombre = allNumbersArray.get(i);
            boolean isPrime = true;

            //Regarder si le nombre est divisible par un des nombres premiers.
            //Si oui, l'enlever de la liste des nombres à verifier
            for(int primeIndex = 0 ; primeIndex < listOfPrimes.size() ; primeIndex++){
                int primeNumber = listOfPrimes.get(primeIndex);
                if(nombre % primeNumber == 0){
                    //Il n'est pas premier, l'enlever de la liste
                    allNumbersArray.remove((Integer) nombre);
                    isPrime = false;
                }
            }

            //Si le nombre n'est divisible par aucun nombre premier trouvés précédement
            if(isPrime){
                //Le nombre n'est divisible par aucun nombre premier dans la liste.
                //On l'ajoute à la liste de nombres premiers
                listOfPrimes.add(nombre);

                //Et on l'enleve de la liste des nombres à considerer
                allNumbersArray.remove((Integer)nombre);
            }
        }

        return listOfPrimes;
    }
}
