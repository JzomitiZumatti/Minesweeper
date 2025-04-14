# Minesweeper – Stage 1: Minefield Display

A basic step in building the classic logic game **Minesweeper** using Java.

---

## 🧠 Description

Minesweeper is a game of logic where the player is presented with a field full of hidden mines. The goal is to mark the positions of all mines **without setting any of them off**.  
It's not about guessing — the game provides hints showing how many mines surround each cell.  
One wrong move, and game over!

---

## 🎯 Objective (Stage 1)

Your task for this stage is simple:  
✅ **Output a visual representation of the minefield.**

- Define the field size (e.g. 9×9).
- Place any number of mines you like (e.g. 10).
- Show the mines in plain sight — we are not hiding them at this point.
- Use any characters you want to represent:
    - Mines (e.g. `X`)
    - Safe cells (e.g. `.`)

Later, we will standardize the symbols, but for now — choose what works for you.

---

## 📌 Example

In this example, there are 10 mines on a 9×9 field:
```text
.X.......
.....X..X
....X....
.....X...
..X......
...X.....
..X......
..X......
.....X...