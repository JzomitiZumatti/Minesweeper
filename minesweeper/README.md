# Minesweeper — Stage 4: Marking Mines

Now that the field is initialized and filled with helpful numbers, it's time to **start playing**! In this stage, the player tries to find the mines by **marking** the cells they believe contain them.

---

## 🎯 Objective

Your upgraded program should meet the following requirements:

1. After initializing the field, all the numbers are shown to the player, but not the positions of the mines.
2. The player sees the message **`Set/delete mine marks (x and y coordinates):`** and enters two numbers as coordinates on the field.
3. The user input is treated according to the rules:
   1. If the player enters the coordinates of a non-marked cell, the program marks the cell, which means that the player thinks a mine is located there.
   2. If the player enters the coordinates of a cell with a number, the program should print the message **`There is a number here!`** and ask the player again without printing the minefield, since cells with numbers are guaranteed to be free of mines.
   3. If the player enters the coordinates of a marked cell, the cell becomes unmarked. This is necessary because the game ends only if all the marks are correct, but the player can mark more cells than there are mines.
4. After successfully marking or unmarking a cell, the new minefield state is printed. The symbol `.` is used to represent non-marked cells, and `*` is for marked ones. The prompt for the player's next move is printed until the game is finished.
5. When the player marks all the mines correctly without marking any empty cells, they win and the game ends. If the player has marked extra cells that do not contain mines, they continue playing. After clearing all the excess mine marks, the player wins. Print the message **`Congratulations! You found all the mines!`** after the final field state.

---

## 🧪 Example Output

The greater-than symbol (`>`) represents user input.

```text
How many mines do you want on the field? `>` 5

 |123456789|
-|---------|
1|.111.....|
2|.1.1.....|
3|.1221....|
4|..1.1....|
5|.1221....|
6|.1.21....|
7|.12.1....|
8|..1221...|
9|...1.1...|
-|---------|
Set/delete mines marks (x and y coordinates): > 2 1
There is a number here!
Set/delete mines marks (x and y coordinates): > 3 2

 |123456789|
-|---------|
1|.111.....|
2|.1*1.....|
3|.1221....|
4|..1.1....|
5|.1221....|
6|.1.21....|
7|.12.1....|
8|..1221...|
9|...1.1...|
-|---------|
Set/delete mines marks (x and y coordinates): > 4 4

 |123456789|
-|---------|
1|.111.....|
2|.1*1.....|
3|.1221....|
4|..1*1....|
5|.1221....|
6|.1.21....|
7|.12.1....|
8|..1221...|
9|...1.1...|
-|---------|
Set/delete mines marks (x and y coordinates): > 3 6

 |123456789|
-|---------|
1|.111.....|
2|.1*1.....|
3|.1221....|
4|..1*1....|
5|.1221....|
6|.1*21....|
7|.12.1....|
8|..1221...|
9|...1.1...|
-|---------|
Set/delete mines marks (x and y coordinates): > 4 7

 |123456789|
-|---------|
1|.111.....|
2|.1*1.....|
3|.1221....|
4|..1*1....|
5|.1221....|
6|.1*21....|
7|.12*1....|
8|..1221...|
9|...1.1...|
-|---------|
Set/delete mines marks (x and y coordinates): > 5 9

 |123456789|
-|---------|
1|.111.....|
2|.1*1.....|
3|.1221....|
4|..1*1....|
5|.1221....|
6|.1*21....|
7|.12*1....|
8|..1221...|
9|...1*1...|
-|---------|
Congratulations! You found all the mines!