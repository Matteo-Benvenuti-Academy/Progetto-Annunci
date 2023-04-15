package com.Annunci.utils;

import java.util.Collections;
import java.util.List;

import com.Annunci.dto.AnnuncioDto;
public class DataSorter {
    public static List<AnnuncioDto> sort(List<AnnuncioDto> listaAnnunci){
        Collections.sort(listaAnnunci,  (pub1, pub2) -> pub2.getPublicazione()
        .compareTo(pub1.getPublicazione()));
        return listaAnnunci;
    }
}
