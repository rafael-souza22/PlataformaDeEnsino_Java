package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.*;

public class Progam {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Lesson> list = new ArrayList<>();

		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();

		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.printf("Dados da %dª aula:%n", i + 1);
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char type = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String titulo = sc.nextLine();

			if (type == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int segundos = sc.nextInt();

				list.add(new Video(titulo, url, segundos));

				System.out.println();
			} else {
				System.out.print("Descrição: ");
				String descricao = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questoes = sc.nextInt();

				list.add(new Task(titulo, descricao, questoes));
			}
		}

		System.out.println();
		int sum = 0;

		for (Lesson lesson : list) {
			sum += lesson.duration();
		}

		System.out.printf("DURAÇÃO TOTAL DO CURSO = %d segundos", sum);

		sc.close();
	}
}