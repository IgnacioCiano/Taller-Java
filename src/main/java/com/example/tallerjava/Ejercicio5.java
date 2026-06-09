package com.example.tallerjava;

import java.util.*;

public class Ejercicio5 {

    public static void main(String[] args) {
        // Test 1: camino simple
        char[][] maze1 = {
            {'E', '.', '.'},
            {'.', '#', '.'},
            {'.', '.', 'S'}
        };
        System.out.println("Test 1: " + minPasos(maze1)); // 4

        // Test 2: sin salida
        char[][] maze2 = {
            {'E', '#'},
            {'#', 'S'}
        };
        System.out.println("Test 2: " + minPasos(maze2)); // -1

        // Test 3: con portales
        char[][] maze3 = {
            {'E', '.', 'a'},
            {'#', '#', '#'},
            {'S', '.', 'a'}
        };
        System.out.println("Test 3: " + minPasos(maze3)); // 2 (E -> a -> teleport -> a -> S)
    }

    public static int minPasos(char[][] maze) {
        int F = maze.length;
        int C = maze[0].length;

        int startR = -1, startC = -1;
        Map<Character, List<int[]>> portales = new HashMap<>();

        for (int i = 0; i < F; i++) {
            for (int j = 0; j < C; j++) {
                char c = maze[i][j];
                if (c == 'E') {
                    startR = i;
                    startC = j;
                } else if (c >= 'a' && c <= 'z') {
                    portales.computeIfAbsent(c, k -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        boolean[][] visited = new boolean[F][C];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC, 0});
        visited[startR][startC] = true;

        Set<Character> portalesUsados = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], steps = cur[2];
            char cell = maze[r][c];

            if (cell == 'S') {
                return steps;
            }

            if (cell >= 'a' && cell <= 'z' && !portalesUsados.contains(cell)) {
                portalesUsados.add(cell);
                List<int[]> samePortals = portales.get(cell);
                if (samePortals != null) {
                    for (int[] p : samePortals) {
                        if (!visited[p[0]][p[1]]) {
                            visited[p[0]][p[1]] = true;
                            queue.add(new int[]{p[0], p[1], steps + 1});
                        }
                    }
                }
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < F && nc >= 0 && nc < C && !visited[nr][nc] && maze[nr][nc] != '#') {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, steps + 1});
                }
            }
        }

        return -1;
    }
}
