### Swing Grid Task

# A small Java Swing app showing a grid of cells.
Implements hover highlight, delete-on-click (in one mode), and click-to-select (in another mode), plus simple keyboard navigation.

Features (what’s implemented)

Two modes (toggle with SPACE):

а) HOVER: hover highlights a cell (green). Left-click deletes the hovered cell.

б) CLICK: Left-click selects a cell and updates the header/title accordingly.

Only one green highlight at a time. Hover overrides keyboard selection.

Empty cells are inert: they don’t highlight, can’t be selected, and clicks on them do nothing.

Column shift on delete: when a cell is deleted, all cells below it in the same column move up, and the bottom cell of that column becomes empty.

Keyboard: ← / → move the selection skipping empty cells.

Header/Title shows the currently selected cell’s text (or "-" if none/empty).

Config validation: throws IllegalArgumentException if ROWS*COLS < PANELS_COUNT, non-positive grid sizes, or invalid highlightIndex.

Controls

Mouse

Hover: highlights non-empty cell (HOVER mode).

Left-click:

HOVER mode: delete hovered cell (column shifts up).

CLICK mode: select cell and update header/title.

Keyboard

← / →: move selection to the previous/next non-empty cell.

SPACE: toggle mode (HOVER ↔ CLICK).

If arrow keys don’t respond, click the grid once to ensure it has focus.

Configuration

Edit constants in MyContainer:

PANELS_COUNT — number of cells to render.

COLS, ROWS — grid dimensions.

The app validates that ROWS * COLS >= PANELS_COUNT. Otherwise it throws:

IllegalArgumentException: Invalid configuration: ROWS*COLS ... < PANELS_COUNT ...

How to Run
Using an IDE (IntelliJ IDEA / Eclipse)

Open the project as a Java project.

Run the class Launcher (it contains the main method).

Project Structure (example)
src/
test/
Launcher.java
MainWindow.java
MyContainer.java
SelectionMode.java

Next steps

- Unit tests for grid model and delete/shift behavior.

- Extract a simple GridModel (data + logic) separate from Swing UI.

- Strategy pattern for selection behaviors (HOVER vs CLICK).