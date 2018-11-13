package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FileTypeSize {

	public static void main(String[] args) {
		/*
		music 1011b
		images 0b
		movies 10200b
		other 105b
		 */

		System.out.println(solution(
			"my.song.mp3 11b\n"
				+ "greatSong.flac 1000b\n"
				+ "not3.txt 5b\n"
				+ "video.mp4 200b\n"
				+ "game.exe 100b\n"
				+ "mov!e.mkv 10000b"));

				/*
		music 2011b
		images 4000000b
		movies 10400b
		other 105b
		 */
		System.out.println(solution(
			"my.song.mp3 11b\n"
				+ "greatSong.flac 1000b\n"
				+ "not3.txt 5b\n"
				+ "video.mp4 200b\n"
				+ "video.avi 200b\n"
				+ "game.exe 100b\n"
				+ "game.gif 1000000b\n"
				+ "game.gif 1000000b\n"
				+ "game.gif 1000000b\n"
				+ "game.gif 0b\n"
				+ "game.jpg 1000000b\n"
				+ "game.aac 1000\n"
				+ "game.bmp 1000000b\n"
				+ "mov!e.mkv 10000b"));
	}

	public static String solution(String S) {
		String[] lines = S.split("\n");

		String musicFileType = "music";
		String imagesFileType = "images";
		String moviesFileType = "movies";
		String otherFileType = "other";
		String bytesSignature = "b";

		Map<String, Integer> typeSizes = new HashMap<>();
		typeSizes.put(musicFileType, 0);
		typeSizes.put(imagesFileType, 0);
		typeSizes.put(moviesFileType, 0);
		typeSizes.put(otherFileType, 0);

		Map<String, String> typeMapping = new HashMap<>();
		typeMapping.put("mp3", musicFileType);
		typeMapping.put("aac", musicFileType);
		typeMapping.put("flac", musicFileType);

		typeMapping.put("jpg", imagesFileType);
		typeMapping.put("bmp", imagesFileType);
		typeMapping.put("gif", imagesFileType);

		typeMapping.put("mp4", moviesFileType);
		typeMapping.put("avi", moviesFileType);
		typeMapping.put("mkv", moviesFileType);

		for (String line : lines) {
			String[] fileInfo = line.split(" ");
			String fileFormat = fileInfo[0].substring(fileInfo[0].lastIndexOf('.') + 1);
			Integer fileSize = Integer.valueOf(fileInfo[1].replace(bytesSignature, ""));

			String fileType = Optional.ofNullable(typeMapping.get(fileFormat)).orElse(otherFileType);
			if (typeSizes.containsKey(fileType)) {
				typeSizes.put(fileType, typeSizes.get(fileType) + fileSize);
			} else {
				typeSizes.put(fileType, fileSize);
			}
		}

		return musicFileType + " " + typeSizes.get(musicFileType) + bytesSignature + "\n"
			+ imagesFileType + " " + typeSizes.get(imagesFileType) + bytesSignature + "\n"
			+ moviesFileType + " " + typeSizes.get(moviesFileType) + bytesSignature + "\n"
			+ otherFileType + " " + typeSizes.get(otherFileType) + bytesSignature;
	}

}
