package com.alexbzmn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Battleship {

	public static void main(String[] args) {
		System.out.println(new Battleship().solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A"));

		int[][] a = new int[][]{};
		Arrays.sort(a, (o1, o2) -> {
			return o1[0] < o2[0] ? -1 : 1;
		});
	}

	public Battleship() {
	}

	public String solution(int N, String S, String T) {
		List<Ship> ships = readShips(S, N * N);
		List<Cell> hitCells = readHits(T, N * N);

		int countHit = 0;
		int countSunken = 0;

		for (Ship current : ships) {
			int currentHits = current.calculateHits(hitCells);
			if (currentHits > 0) {
				if (currentHits == current.getSize()) {
					countSunken++;
				} else {
					countHit++;
				}
			}
		}

		return String.format("%d,%d", countSunken, countHit);
	}

	public static List<Cell> readHits(String hits, int maxHits) {
		List<Cell> hitsList = new ArrayList<Cell>(maxHits);
		String[] coordinates = hits.split(" ");
		for (String c : coordinates) {
			hitsList.add(new Cell(c));
		}
		return hitsList;
	}

	public static List<Ship> readShips(String ships, int maxShips) {
		List<Ship> shipsList = new ArrayList<Ship>(maxShips);
		String[] shipsCoords = ships.split(",");
		for (String shipCoord : shipsCoords) {
			String[] coords = shipCoord.split(" ");
			shipsList.add(new Ship(new Cell(coords[0]), new Cell(coords[1])));
		}
		return shipsList;
	}

	static public class Cell {

		int x;
		int y;

		public Cell(String c) {
			x = (c.toUpperCase().charAt(1)) - ('A');
			y = (c.charAt(0)) - ('1');
		}

		public boolean greaterOrEqual(Cell other) {
			return x >= other.x && y >= other.y;
		}

	}

	static public class Ship {

		Cell left;
		Cell right;

		public Ship(Cell left, Cell right) {
			this.left = left;
			this.right = right;
		}

		public int getSize() {
			return (Math.abs(left.x - right.x) + 1)
				* (Math.abs(left.y - right.y)) + 1;
		}

		public int calculateHits(List<Cell> shots) {
			int hits = 0;
			for (Cell shot : shots) {
				if (shot.greaterOrEqual(left) && right.greaterOrEqual(shot)) {
					hits++;
				}
			}
			return hits;
		}
	}

}
