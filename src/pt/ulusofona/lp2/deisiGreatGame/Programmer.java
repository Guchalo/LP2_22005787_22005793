package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmer {
    private int id;
    private String name;
    private ProgrammerColor color;
    private String image;
    private int pos = 1;
    private ArrayList<String> linguagensProg = new ArrayList<>();
    private boolean estado = true;
    private boolean cicloInfinito = false;
    private final List<Tool> tools = new ArrayList<>();
    private static int valorDoDado = 0;
    private final ArrayList<Integer> nrJogadas = new ArrayList<>(2);


    public Programmer() {
    }

    public boolean getEstado() {
        return estado;
    }

    public String getImage() {
        return image;
    }

    public boolean isCicloInfinito() {
        return cicloInfinito;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public static int getValorDoDado() {
        return valorDoDado;
    }

    public ArrayList<Integer> getNrJogadas() {
        return nrJogadas;
    }

    public static int getValorDado() {
        return valorDoDado;
    }

    public boolean moverPos(int nrPositions, int size) {
        valorDoDado = nrPositions;
        nrJogadas.add(valorDoDado);
        if (pos + nrPositions > size) {
            int diferenca = (pos + nrPositions) - size;
            int alcancarSize = size - pos;
            pos += alcancarSize;
            pos -= diferenca;
            return true;
        }
        pos += nrPositions;
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

    public Programmer(int id, String name, ProgrammerColor color, ArrayList<String> linguagensProg) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.image = color.getCor();
        this.linguagensProg = linguagensProg;
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

    public boolean posicaoValidaSF(int posicion) {
        return posicion == pos;
    }

    public String stringEstado() {
        if (estado) {
            return "Em Jogo";
        } else {
            return "Derrotado";
        }
    }

    public void derrotado() {
        if (!estado) {
            return;
        } else {
            estado = false;
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

    public String getLinguagensProg() {
        Collections.sort(linguagensProg);
        StringBuilder linguagens = new StringBuilder();
        for (String linguagem : linguagensProg) {
            linguagens.append(linguagem);
            linguagens.append("; ");
        }
        return linguagens.substring(0, linguagens.length() - 2);
    }

    public String toStringTools() {
        if (tools == null || tools.size() == 0) {
            return "No tools";
        }
        StringBuilder resultado = new StringBuilder();
        for (Tool ferramenta : tools) {
            resultado.append(ferramenta.getTitulo()).append(";");
        }
        return resultado.substring(0, resultado.length() - 1);
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

    @Override
    public String toString() {
        return "" + id + " | " + name + " | " + pos + " | " + toStringTools() + " | " + getLinguagensProg() + " | " + stringEstado();
    }
}
