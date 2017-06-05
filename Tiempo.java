/*
	Programa: Buscaminas Java
	Autor: Borja
	Web: http://todojava.awardspace.com/
	Version: 1.0
	
	Descripción: El mítico juego del buscaminas. Clase del tiempo, con ella corren los segundos 
	en la caja de texto.
	
	Dificultad: Media
	
	Para más información sobre Threads vete a http://todojava.awardspace.com/manuales-java.html
	descárgate el manual de: Threads, Programación multihebra
*/

//	Clase Temporizador

//package buscaminas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Tiempo extends Thread {

	//clase del buscamintas
	buscaminas bd;
	
	//Parar cronómetro
	boolean Salir=false;
	
	//Contador de segundos
	int seg=0;
	
	Tiempo (JFrame j){
		System.out.println("\n Comienza el tiempo...");
		//copia la clase del buscaminas en el objeto bd. Con esto
		//podemos referirnos a los atribustos de la clase del buscaminas y 
		//cambiar el tiempo de la caja txtTiempo
		
		bd=(buscaminas)j;
	}
	
	public void run()	//método run, obligatorio en el thread
	{
		while(!Salir){
			try
			{
			//Retardar 1000 milisegutndos
			sleep(1000);
			seg++;		
			bd.txtTiempo.setText(Integer.toString(seg));
			}
			catch(InterruptedException ie)
			{
				System.out.println(ie);
			}
		}
	}
	
	public void parar(boolean b)
	{
		//método para parar el cronómetro
		if(b)Salir=true;
		seg=0;
	}

}