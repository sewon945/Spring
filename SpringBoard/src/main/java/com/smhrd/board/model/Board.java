package com.smhrd.board.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Board {
	private int idx;
	private String title;
	private String content;
	private String writer;
	private String img;
	private String indate;
}
