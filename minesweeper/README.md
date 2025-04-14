# Minesweeper — Stage 2: Random Minefield

In this stage, we introduce randomness into the game.  
It's no fun when the field has the same setup every time and you already know where all the mines are. Let's generate a **new configuration every time** the game starts!

---

## 🎯 Objective

- Prompt the player with:  
  **`How many mines do you want on the field?`**

- Read the number of mines from the user input.

- Generate a **9×9** field with that many randomly placed mines (`X`), and fill the remaining cells with dots (`.`) to represent safe cells.

- Display the field to the player (mines are still visible at this stage).

---

## ✅ Requirements

- The field must be **randomized** on each run.
- The number of mines must **match the user input** exactly.
- Do not place multiple mines in the same cell.
- Use the following symbols:
  - `X` — for mines
  - `.` — for safe cells

---

## 💡 Example Output

The greater-than symbol (`>`) represents user input.
How many mines do you want on the field? `>` 10

```text
........X
........X
......X.X
X........
.........
......X..
XX......X
.........
.....X...