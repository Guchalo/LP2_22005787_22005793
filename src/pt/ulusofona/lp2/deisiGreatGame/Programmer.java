package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmer {
    private int id;
    private String name;
    private ProgrammerColor color;
    private String image;
    private int pos;
    private ArrayList<String> linguagensProg = new ArrayList<>();
    private boolean estado = true;
    private boolean cicloInfinito = false;
    private List<Tool> tools = new ArrayList<>();
    private static int valorDoDado = 0;
    private ArrayList<Integer> nrJogadas = new ArrayList<>(2);
    private int numeroLinguagens = 0;
    private ArrayList<Integer> posicoes = new ArrayList<>();
    private double posicaoTemp;


    public Programmer() {
    }

    public Programmer(int id, String name, ProgrammerColor color, ArrayList<String> linguagensProg) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.image = color.getCor();
        this.linguagensProg = linguagensProg;
        this.numeroLinguagens = linguagensProg.size();
        this.pos = 1;
    }

    public Programmer(int id, String name, ProgrammerColor color, ArrayList<String> linguagensProg, int pos,
                      boolean cicloInfinito, List<Tool> tools, ArrayList<Integer> nrJogadas, boolean estado) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.pos = pos;
        this.linguagensProg = linguagensProg;
        this.estado = estado;
        this.cicloInfinito = cicloInfinito;
        this.tools = tools;
        this.nrJogadas = nrJogadas;
    }

    public int getNumeroLinguagens() {
        return numeroLinguagens;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProgrammerColor getColor() {
        return color;
    }

    public int getPos() {
        return pos;
    }

    public boolean getEstado() {
        return estado;
    }

    public int getEstadoToInt() {
        if (estado) {
            return 1;
        }
        return 0;
    }

    public int getCicloInfToInt() {
        if (cicloInfinito) {
            return 1;
        }
        return 0;
    }

    public String getImage() {
        return image;
    }

    public String getLinguagensProg() {
        Collections.sort(linguagensProg);
        StringBuilder linguagens = new StringBuilder();
        for (String linguagem : linguagensProg) {
            linguagens.append(linguagem);
            linguagens.append("; ");
        }
        return linguagens.substring(0, linguagens.length() - 2);
    }

    public List<Tool> getTools() {
        return tools;
    }

    public boolean isCicloInfinito() {
        return cicloInfinito;
    }

    public static int getValorDoDado() {
        return valorDoDado;
    }

    public ArrayList<Integer> getNrJogadas() {
        return nrJogadas;
    }

    public boolean moverPos(int nrPositions, int size) {
        valorDoDado = nrPositions;
        nrJogadas.add(getValorDoDado());
        if (pos + nrPositions > size) {
            int diferenca = (pos + nrPositions) - size;
            int alcancarSize = size - pos;
            pos += alcancarSize;
            pos -= diferenca;
            posicoes.add(pos);
            return true;
        }
        pos += nrPositions;
        posicoes.add(pos);
        return true;
    }

    public void posicao2Jogadas() {
        int posicao = nrJogadas.get(nrJogadas.size() - 1) + nrJogadas.get(nrJogadas.size() - 2);
        pos -= posicao;
    }

    public void recuar(int nrPositions) {
        if ((pos - nrPositions) < 1) {
            pos = 1;
            return;
        }
        pos -= (nrPositions);
    }

    public void voltarPracasa() {
        pos = 1;
    }

    public void erroDeLogica() {
        pos -= (valorDoDado / 2);
    }

    public void voltarOndeEstava() {
        pos -= valorDoDado;
    }

    public void ativarCicloInfinito() {
        cicloInfinito = true;
    }

    public void desativarCicloInfinito() {
        cicloInfinito = false;
    }

    public boolean posicaoValidaSF(int posicion) {
        return posicion == pos;
    }

    public void derrotado() {
        estado = false;
    }

    public void media3CasasAnteriores(){

        if (posicoes.size() >= 3){
            double positions1 = pos - nrJogadas.get(nrJogadas.size() - 1);
            double positions2 = pos - nrJogadas.get(nrJogadas.size() - 2);
            double positions3 = pos - nrJogadas.get(nrJogadas.size() - 3);
            double somaPositions = positions1 + positions2 + positions3;
            posicaoTemp = Math.ceil(somaPositions / 3);
            pos = (int)posicaoTemp;
            return;
        }
        if (posicoes.size()  == 2){
            double positions1 = pos - nrJogadas.get(nrJogadas.size() - 1);
            double positions2 = pos - nrJogadas.get(nrJogadas.size() - 2);
            double somaPositions = positions1 + positions2;
            posicaoTemp = Math.ceil(somaPositions / 2);
            pos = (int)posicaoTemp;
            return;
        }
        if (posicoes.size() == 1){
            pos = pos - nrJogadas.get(nrJogadas.size() - 1);
        }
    }

    public void adicionarTool(Tool t) {
        if (t == null) {
            return;
        }
        for (Tool tool : tools) {
            if (tool.getTitulo().equals(t.getTitulo())) {
                return;
            }
        }
        tools.add(t);
    }

    public void removerTool(String t) {
        if (t == null) {
            return;
        }
        tools.removeIf(tool -> tool.getTitulo().equals(t));
    }

    public boolean temEA() {
        for (Tool tool : tools) {
            if (tool.getTitulo().equals("Tratamento de Excepções")) {
                return true;
            }
        }
        return false;
    }

    public boolean temFP() {
        for (Tool tool : tools) {
            if (tool.getTitulo().equals("Programação Funcional")) {
                return true;
            }
        }
        return false;
    }

    public boolean temHeranca() {
        for (Tool tool : tools) {
            if (tool.getTitulo().equals("Herança")) {
                return true;
            }
        }
        return false;
    }

    public boolean temIDE() {
        for (Tool tool : tools) {
            if (tool.getTitulo().equals("IDE")) {
                return true;
            }
        }
        return false;
    }

    public boolean temTH() {
        for (Tool tool : tools) {
            if (tool.getTitulo().equals("Ajuda Do Professor")) {
                return true;
            }
        }
        return false;
    }

    public boolean temUT() {
        for (Tool tool : tools) {
            if (tool.getTitulo().equals("Testes unitários")) {
                return true;
            }
        }
        return false;
    }

    public String stringEstado() {
        if (estado) {
            return "Em Jogo";
        } else {
            return "Derrotado";
        }
    }

    public String getNrJogadasToString() {
        if (nrJogadas == null || nrJogadas.size() == 0) {
            return "0";
        }
        StringBuilder resultado = new StringBuilder();
        for (Integer i : nrJogadas) {
            resultado.append(i).append(";");
        }
        return resultado.substring(0, resultado.length() - 1);
    }

    public String toStringTools() {
        if (tools.size() == 0) {
            return "No tools";
        }
        StringBuilder resultado = new StringBuilder();
        for (Tool ferramenta : tools) {
            resultado.append(ferramenta.getTitulo()).append(";");
        }
        return resultado.substring(0, resultado.length() - 1);
    }

    @Override
    public String toString() {
        return "" + id + " | " + name + " | " + pos + " | " + toStringTools() + " | " + getLinguagensProg()
                + " | " + stringEstado();
    }
}
