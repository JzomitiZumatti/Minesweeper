# Minesweeper — Stage 3: Look around you

Now it's time to make the game more playable by providing **hints** — numbers that indicate how many mines surround each cell. This gives the player real tools to logically deduce where the mines are.

---

## 🎯 Objective

- As before, prompt the user to input the number of mines with:

  **`How many mines do you want on the field?`**

- Randomly place the given number of mines on a **9×9 field**.

- For each **empty cell** (not containing a mine), check how many mines surround it (up to 8 surrounding cells).

- Replace each empty cell with a **number** from 1 to 8 if there are any adjacent mines.  
  If there are **no mines** around, leave it as `.`

- Mines should still be shown as `X`.

---

## 🔍 Checking Logic

- Each cell may have up to **8 neighbors** (N, NE, E, SE, S, SW, W, NW).
- For **corner cells**, check only the valid 3 neighbors.
- For **edge cells**, check 5.
- For **center cells**, check all 8.

Use boundary checks to avoid `ArrayIndexOutOfBoundsException`.

---

## 🧪 Example Output

The greater-than symbol (`>`) represents user input.
How many mines do you want on the field? `>` 10

```text
.........
.111111..
.1X22X211
.112X33X1
...12X211
....1221.
..1111X1.
123X1222.
1XX211X1.