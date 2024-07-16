// Function to check if a number can be placed in a specific cell
function isValid(board, row, col, num) {
    for (let x = 0; x < 9; x++) {
        if (board[row][x] == num || board[x][col] == num || 
            board[3 * Math.floor(row / 3) + Math.floor(x / 3)][3 * Math.floor(col / 3) + x % 3] == num) {
            return false;
        }
    }
    return true;
}

// Function to solve the Sudoku puzzle using backtracking
function solve(board) {
    for (let row = 0; row < 9; row++) {
        for (let col = 0; col < 9; col++) {
            if (board[row][col] == null) {
                for (let num = 1; num <= 9; num++) {
                    if (isValid(board, row, col, num)) {
                        board[row][col] = num;
                        if (solve(board)) {
                            return true;
                        }
                        board[row][col] = null;
                    }
                }
                return false;
            }
        }
    }
    return true;
}

// Function to collect the inputs from the Sudoku grid and solve it
function solveSudoku() {
    let board = [];
    for (let row = 0; row < 9; row++) {
        let rowValues = [];
        for (let col = 0; col < 9; col++) {
            let cellValue = document.getElementById('cell-' + row + '-' + col).value;
            rowValues.push(cellValue ? parseInt(cellValue) : null);
        }
        board.push(rowValues);
    }

    if (solve(board)) {
        for (let row = 0; row < 9; row++) {
            for (let col = 0; col < 9; col++) {
                document.getElementById('cell-' + row + '-' + col).value = board[row][col];
            }
        }
        alert('Sudoku Solved!');
    } else {
        alert('No solution exists!');
    }
}

// Function to clear the Sudoku grid
function clearSudoku() {
    for (let row = 0; row < 9; row++) {
        for (let col = 0; col < 9; col++) {
            document.getElementById('cell-' + row + '-' + col).value = '';
        }
    }
}