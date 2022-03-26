package com.revature.main;

import io.javalin.Javalin;

public class App {
public static void main(String[] args) {
	Javalin app = Javalin.create().start(7070);
}
}
