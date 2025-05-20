/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ldpfinalproject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ldpfinalproject.Cell.CellType;

/**
 *
 * @author patri
 */

public class Board implements Serializable {
    private List<Cell> cells;                            // 0..71, trajeto principal
    private Map<PlayerColor, List<Cell>> homeColumns;    // colunas finais
    private Map<PlayerColor, Cell> startCells;           // células de saída

    public Board(List<Cell> cells,
                 Map<PlayerColor, List<Cell>> homeColumns,
                 Map<PlayerColor, Cell> startCells) {
        this.cells = cells;
        this.homeColumns = homeColumns;
        this.startCells = startCells;
    }
    
    public Board() {
    this.cells = initMainTrack(); // Lista com 72 células, por exemplo
    this.homeColumns = initHomeColumns();
    this.startCells = initStartCells();
}

private List<Cell> initMainTrack() {
    List<Cell> track = new ArrayList<>();
    for (int i = 0; i < 72; i++) {
        track.add(new Cell(i, CellType.NORMAL, null)); // célula normal, sem cor
    }
    return track;
}

private Map<PlayerColor, List<Cell>> initHomeColumns() {
    Map<PlayerColor, List<Cell>> map = new HashMap<>();
    for (PlayerColor color : PlayerColor.values()) {
        List<Cell> col = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            col.add(new Cell(-1, CellType.HOME, color)); // célula home com cor
 // usa -1 ou índices especiais
        }
        map.put(color, col);
    }
    return map;
}

private Map<PlayerColor, Cell> initStartCells() {
    Map<PlayerColor, Cell> map = new HashMap<>();
    map.put(PlayerColor.RED, cells.get(0));
    map.put(PlayerColor.GREEN, cells.get(18));
    map.put(PlayerColor.BLUE, cells.get(36));
    map.put(PlayerColor.YELLOW, cells.get(54));
    return map;
}

    public List<Cell> getCells() {
        return cells;
    }

    public List<Cell> getHomeColumn(PlayerColor color) {
        return homeColumns.get(color);
    }

    public Cell getStartCell(PlayerColor color) {
        return startCells.get(color);
    }

    /** Calcula a casa destino para mover `steps` à frente, considerando o trajeto e as colunas home.
     * @param piece
     * @param steps
     * @return  */
    // Board.java
public Cell getNextCell(Piece piece, int steps) {
    if (!piece.isActive()) {
        return null;
    }
    Cell current = piece.getPosition();
    int currentIndex = current.getIndex();
    int entryIndex = getEntryIndex(piece.getOwner().getColor());
    
    // Verificar se está prestes a entrar na coluna final
    int stepsToHome = (entryIndex + 72 - currentIndex) % 72;
    if (steps > stepsToHome) {
        int homeIndex = steps - stepsToHome - 1;
        List<Cell> home = homeColumns.get(piece.getOwner().getColor());
        if (homeIndex < home.size()) {
            return home.get(homeIndex);
        } else {
            return null; // não pode mover, ultrapassa home
        }
    }
    
    int nextIndex = (currentIndex + steps) % 72;
    return cells.get(nextIndex);
}


    private int getEntryIndex(PlayerColor color) {
        // Retorna o índice na lista principal onde cada cor entra no tabuleiro
        switch (color) {
            case RED -> {
                return 0;
            }
            case GREEN -> {
                return 18;
            }
            case BLUE -> {
                return 36;
            }
            case YELLOW -> {
                return 54;
            }
            default -> throw new IllegalArgumentException();
        }
    }

    /** Move a peça e trata captura/bloco
     * @param piece
     * @param steps */
    public void movePiece(Piece piece, int steps) {
        if (!piece.isActive() && steps == 6) {
            // ativa e posiciona na casa de saída
            Cell start = getStartCell(piece.getOwner().getColor());
            piece.activate(start);
            return;
        }
        if (!piece.isActive()) {
            // não pode mover
            return;
        }
        Cell dest = getNextCell(piece, steps);
        // captura se houver peça adversária
        dest.getOccupant().ifPresent(op -> {
            if (!op.getOwner().equals(piece.getOwner())) {
                op.sendToStart();
            }
        });
        // move peça
        piece.moveTo(dest);
    }
    
    public void reset() {
    for (Cell cell : cells) {
        cell.clearOccupant();
    }
}
    

}