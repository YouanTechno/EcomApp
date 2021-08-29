package com.example.ecomapp.models;

import java.util.Date;

public class Factures {
    public int FactId ;
    public String FactCode;
    public int FactTaxactId;
    public int FactContId;
    public int FactActId ;
    public int FactCpteId;
    public double FactMontant;
    public String FactPeriodeDebut;
    public Date FactPeriodeFin;
    public String FactDateEmission ;
    public String FactDateEcheance ;
    public Boolean FactBEtatReglement ;
    public String FactLibelle ;
    public Boolean FactBAbandon;
    public String FactDateaBandon;
    public int FactAbandonAgId;
    public String FactAbandonMotif;

    public int getFactId() {
        return FactId;
    }

    public void setFactId(int factId) {
        FactId = factId;
    }

    public String getFactCode() {
        return FactCode;
    }

    public void setFactCode(String factCode) {
        FactCode = factCode;
    }

    public int getFactTaxactId() {
        return FactTaxactId;
    }

    public void setFactTaxactId(int factTaxactId) {
        FactTaxactId = factTaxactId;
    }

    public int getFactContId() {
        return FactContId;
    }

    public void setFactContId(int factContId) {
        FactContId = factContId;
    }

    public int getFactActId() {
        return FactActId;
    }

    public void setFactActId(int factActId) {
        FactActId = factActId;
    }

    public int getFactCpteId() {
        return FactCpteId;
    }

    public void setFactCpteId(int factCpteId) {
        FactCpteId = factCpteId;
    }

    public double getFactMontant() {
        return FactMontant;
    }

    public void setFactMontant(float factMontant) {
        FactMontant = factMontant;
    }

    public String getFactPeriodeDebut() {
        return FactPeriodeDebut;
    }

    public void setFactPeriodeDebut(String factPeriodeDebut) {
        FactPeriodeDebut = factPeriodeDebut;
    }

    public Date getFactPeriodeFin() {
        return FactPeriodeFin;
    }

    public void setFactPeriodeFin(Date factPeriodeFin) {
        FactPeriodeFin = factPeriodeFin;
    }

    public String getFactDateEmission() {
        return FactDateEmission;
    }

    public void setFactDateEmission(String factDateEmission) {
        FactDateEmission = factDateEmission;
    }

    public String getFactDateEcheance() {
        return FactDateEcheance;
    }

    public void setFactDateEcheance(String factDateEcheance) {
        FactDateEcheance = factDateEcheance;
    }

    public Boolean getFactBEtatReglement() {
        return FactBEtatReglement;
    }

    public void setFactBEtatReglement(Boolean factBEtatReglement) {
        FactBEtatReglement = factBEtatReglement;
    }

    public String getFactLibelle() {
        return FactLibelle;
    }

    public void setFactLibelle(String factLibelle) {
        FactLibelle = factLibelle;
    }

    public Boolean getFactBAbandon() {
        return FactBAbandon;
    }

    public void setFactBAbandon(Boolean factBAbandon) {
        FactBAbandon = factBAbandon;
    }

    public String getFactDateaBandon() {
        return FactDateaBandon;
    }

    public void setFactDateaBandon(String factDateaBandon) {
        FactDateaBandon = factDateaBandon;
    }

    public int getFactAbandonAgId() {
        return FactAbandonAgId;
    }

    public void setFactAbandonAgId(int factAbandonAgId) {
        FactAbandonAgId = factAbandonAgId;
    }

    public String getFactAbandonMotif() {
        return FactAbandonMotif;
    }

    public void setFactAbandonMotif(String factAbandonMotif) {
        FactAbandonMotif = factAbandonMotif;
    }

    public int getFactPotentiel() {
        return FactPotentiel;
    }

    public void setFactPotentiel(int factPotentiel) {
        FactPotentiel = factPotentiel;
    }

    public int FactPotentiel;

    public Factures(){

    }

    public Factures(String factCode, int factTaxactId, double factMontant, String factDateEcheance, String factLibelle) {
        this.FactCode = factCode;
        this.FactTaxactId = factTaxactId;
        this.FactMontant = factMontant;
        this.FactDateEcheance = factDateEcheance;
        this.FactLibelle = factLibelle;
    }

    public Factures(int factId, String factCode, int factTaxactId, int factContId, int factActId, int factCpteId, double factMontant, String factPeriodeDebut, Date factPeriodeFin, String factDateEmission, String factDateEcheance, Boolean factBEtatReglement, String factLibelle, Boolean factBAbandon, String factDateaBandon, int factAbandonAgId, String factAbandonMotif, int factPotentiel) {
        FactId = factId;
        FactCode = factCode;
        FactTaxactId = factTaxactId;
        FactContId = factContId;
        FactActId = factActId;
        FactCpteId = factCpteId;
        FactMontant = factMontant;
        FactPeriodeDebut = factPeriodeDebut;
        FactPeriodeFin = factPeriodeFin;
        FactDateEmission = factDateEmission;
        FactDateEcheance = factDateEcheance;
        FactBEtatReglement = factBEtatReglement;
        FactLibelle = factLibelle;
        FactBAbandon = factBAbandon;
        FactDateaBandon = factDateaBandon;
        FactAbandonAgId = factAbandonAgId;
        FactAbandonMotif = factAbandonMotif;
        FactPotentiel = factPotentiel;
    }
}
