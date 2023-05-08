package it.corsojava.cashreg.core.implementation;

import it.corsojava.cashreg.core.*;
import it.corsojava.cashreg.core.datatypes.specifici.Iva;
import it.corsojava.cashreg.core.exceptions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RegistratoreScontriniImpl implements RegistratoreScontrini {

    private List<Articolo> articoli;

    public RegistratoreScontriniImpl(){
        loadArticoli();
    }

    private void loadArticoli(){
        // codArticolo;barcode;denominazione;descrizione;prezzoUnitario;aliquotaIva
        String source = it.corsojava.datasources.StringDataSources.getArticoli();
        String[] lines = source.split("\n");
        articoli=new ArrayList<Articolo>();
        for(int i=1; i<lines.length;i++){
            Articolo a = ArticoloImpl.fromTextLine(lines[i]);
            articoli.add(a);
        }
    }

    @Override
    public List<Articolo> getArticoli() {
        return articoli;
    }

    @Override
    public Scontrino creaScontrinoVendita() throws ScontrinoCreateException {
        return null;
    }

    @Override
    public Scontrino creaStorno() throws ScontrinoCreateException {
        return null;
    }

    @Override
    public Scontrino getCurrentScontrino() {
        return null;
    }

    @Override
    public Riga addRigaToCurrentScontrino(Articolo a) throws ScontrinoAddRigaException {
        return null;
    }

    @Override
    public Riga addRigaToCurrentScontrinoByBarcode(String barcode) throws ScontrinoAddRigaException {
        return null;
    }

    @Override
    public Scontrino chiudiCurrentScontrino() throws ScontrinoCloseException {
        return null;
    }

    @Override
    public Scontrino popolaStornoDaScontrino(Scontrino s) throws StornoImportException {
        return null;
    }

    @Override
    public Optional<Scontrino> findScontrino(String id) {
        return Optional.empty();
    }

    @Override
    public Scontrino venditeGiornaliereEffettuaChiusura() throws ChiusuraDiCassaException {
        return null;
    }

    @Override
    public List<Scontrino> getVenditeGiornaliereElencoScontrini(LocalDate giorno) {
        return null;
    }

    @Override
    public double getVenditeGiornaliereParziale(LocalDateTime momento) {
        return 0;
    }

    @Override
    public double getVenditeGiornaliereTotale(LocalDate giorno) {
        return 0;
    }

    @Override
    public double getVenditeGeneraliTotaleComplessivo() {
        return 0;
    }

    @Override
    public Map<LocalDate, Double> getVenditeGeneraliTotaliGiornalieri(LocalDate dal, LocalDate al) throws ScontrinoSearchException {
        return null;
    }
}
