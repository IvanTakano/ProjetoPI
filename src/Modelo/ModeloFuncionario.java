/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ivanyuratakano
 */
public class ModeloFuncionario {
    private String nomeFuncionario;
    private int codFunfionario;
    private int telefone;
    private int funcao;

    /**
     * @return the nomeFuncionario
     */
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * @param nomeFuncionario the nomeFuncionario to set
     */
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    /**
     * @return the codFunfionario
     */
    public int getCodFunfionario() {
        return codFunfionario;
    }

    /**
     * @param codFunfionario the codFunfionario to set
     */
    public void setCodFunfionario(int codFunfionario) {
        this.codFunfionario = codFunfionario;
    }

    /**
     * @return the telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the funcao
     */
    public int getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(int funcao) {
        this.funcao = funcao;
    }
}
