package com.gingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Main extends Activity implements OnClickListener {

	TextView lblWord;
	EditText textInput;
	Button buttonE, buttonR, buttonT, buttonY, buttonU, buttonI, buttonO,
			buttonP, buttonA, buttonS, buttonD, buttonF, buttonG, buttonH,
			buttonJ, buttonK, buttonL, buttonZ, buttonX, buttonC, buttonV,
			buttonB, buttonN, buttonM, buttonQ, buttonW;
	String guess = "";
	int pos = 0;
	int guesses = 0;
	int counter = 0;
	int count = 0;
	String[] answers = { "Orso", "Castor", "Gatto", "Cervo", "Cane",
			"Elefante", "Pesce", "Volpe", "Capra", "Gorilla", "Cavallo",
			"Leopardo", "Lama", "Scimmia", "Topo", "Panda", "Pinguino",
			"Cucciolo", "Coniglio", "Ratto", "Rinoceronte", "Pecora",
			"Scoiattolo", "Tigre", "Balena", "Lupo", "Zebra", "Frullatore",
			"Lavastoviglie", "Ferro", "Microonde", "Forno", "Tostapane",
			"Torta", "Ghiaccio", "Gelato", "Regalo", "Sabbia", "Bagno",
			"Panchina", "Ristorante", "Negozio", "Borsa", "Casa", "Mercato",
			"Scontrino", "Specchio", "Doccia", "Sveglia", "Letto", "Coperta",
			"Soffitto", "Armadio", "Muro", "Lampada", "Comodino", "Mento",
			"Cervello", "Pancia", "Schiena", "Braccio", "Occhio", "Fronte",
			"Stomaco", "Capelli", "Testa", "Gamba", "Bocca", "Collo", "Lingua",
			"Dito", "Gola", "Naso", "Denti", "Cintura", "Guanti", "Borsa",
			"Cravatta", "Calzini", "Gonna", "Scarpe", "Sandali", "Maglia",
			"Viola", "Argento", "Bianco", "Giallo", "Verde", "Grigio",
			"Castano", "Nero", "Fratello", "Padre", "Madre", "Nonna",
			"Sorella", "Genero", "Moglie", "Marito", "Cognata", "Colazione",
			"Pranzo", "Cena", "Dolce", "Pollo", "Gormaggio", "Maiale insalata",
			"Panino", "Acqua", "Banana", "Burro", "Succo", "Pomodo", "Divano",
			"Poltrona", "Tavolo", "Quadro", "Batteria", "Chitarra", "Tromba",
			"Pianoforte", "Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio",
			"Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre",
			"Dicembre", "Rupe", "Fiore", "Giardino", "Erbe", "Lago", "Albero",
			"Riva", "Mare", "Fiume", "Pianta", "Oceano", "Zero", "Uno", "Due",
			"Tre", "Quattro", "Cinque", "Sei", "Sette", "Otto", "Nove",
			"Dieci", "Undici", "Dodici", "Tredici", "Quindici", "Sedici",
			"Diciotto", "Venti", "Cento", "Mille", "Porta", "Garage", "Prato",
			"Tetto", "Terrazza", "Camino", "Attore", "Artista", "Atleta",
			"Barbiere", "Direttore", "Cuoco", "Allenatore", "Dentista",
			"Ingegnere", "Agricoltore", "Cameriere", "Cronista", "Professore",
			"Presidente", "Meccanico", "Postino", "Avvocato", "Sedia", "Conto",
			"Tazza", "Forchetta", "Coltello", "Tovagliolo", "Pepe", "Piatto",
			"Caraffa", "Sale", "Arte", "Terra", "Inglese", "Galassia",
			"Storia", "Lingua", "Luna", "Sole", "Stelle", "Scienze", "Musica",
			"Calcio", "Partita", "pallavolo", "Tennis", "Squadra",
			"Macchina", "Pomeriggio", "Alba", "Autunno", "Primavera",
			"Estate", "Inverno", "Sera", "Mezzanotte", "Mattina", "Notte",
			"Pila", "Corda", "Sega", "Metro", "Ruota", "Palla", "Pastelli",
			"Gomma", "Bambola", "Slitta", "Aereo", "Barca", "Volo",
			"Biglietto", "Valigia", "Nave", "Stanza", "Fila", "Pizzeria",
			"Bicicletta", "Camion", "Treno", "Taxi", "Freddo", "Caldo",
			"Nebbioso", "Neve", "Pioggia", "Tornado" };
	String[] words = new String[answers.length];
	Random r = new Random();
	List<String> list = new ArrayList<String>();

	public void generateGuesses() {
		for (int i = 0; i < answers.length; i++) {
			answers[i] = answers[i].toUpperCase();
			int pos = 0;
			if (answers[i].length() > 3)
				pos = r.nextInt(answers[i].length() - 2) + 1;
			else
				pos = 1;
			System.out.println("pos: " + pos);
			words[i] = answers[i].substring(0, pos) + "_"
					+ answers[i].substring(pos + 1);
			System.out.println("Words: " + words[i]);
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		lblWord = (TextView) findViewById(R.id.lblWord);
		buttonE = (Button) findViewById(R.id.ButtonE);
		buttonR = (Button) findViewById(R.id.ButtonR);
		buttonT = (Button) findViewById(R.id.ButtonT);
		buttonY = (Button) findViewById(R.id.ButtonY);
		buttonU = (Button) findViewById(R.id.ButtonU);
		buttonI = (Button) findViewById(R.id.ButtonI);
		buttonO = (Button) findViewById(R.id.ButtonO);
		buttonP = (Button) findViewById(R.id.ButtonP);
		buttonA = (Button) findViewById(R.id.ButtonA);
		buttonS = (Button) findViewById(R.id.ButtonS);
		buttonD = (Button) findViewById(R.id.ButtonD);
		buttonF = (Button) findViewById(R.id.ButtonF);
		buttonG = (Button) findViewById(R.id.ButtonG);
		buttonH = (Button) findViewById(R.id.ButtonH);
		buttonJ = (Button) findViewById(R.id.ButtonJ);
		buttonK = (Button) findViewById(R.id.ButtonK);
		buttonL = (Button) findViewById(R.id.ButtonL);
		buttonZ = (Button) findViewById(R.id.ButtonZ);
		buttonX = (Button) findViewById(R.id.ButtonX);
		buttonC = (Button) findViewById(R.id.ButtonC);
		buttonV = (Button) findViewById(R.id.ButtonV);
		buttonB = (Button) findViewById(R.id.ButtonB);
		buttonN = (Button) findViewById(R.id.ButtonN);
		buttonM = (Button) findViewById(R.id.ButtonM);
		buttonQ = (Button) findViewById(R.id.ButtonQ);
		buttonW = (Button) findViewById(R.id.ButtonW);

		for (int i = 0; i < words.length; i++) {
			list.add(String.valueOf(i).toString());
		}

		Collections.shuffle(list);

		System.out.println("list: " + list);

		buttonE.setOnClickListener(this);
		buttonR.setOnClickListener(this);
		buttonT.setOnClickListener(this);
		buttonY.setOnClickListener(this);
		buttonU.setOnClickListener(this);
		buttonI.setOnClickListener(this);
		buttonO.setOnClickListener(this);
		buttonP.setOnClickListener(this);
		buttonA.setOnClickListener(this);
		buttonS.setOnClickListener(this);
		buttonD.setOnClickListener(this);
		buttonF.setOnClickListener(this);
		buttonG.setOnClickListener(this);
		buttonH.setOnClickListener(this);
		buttonJ.setOnClickListener(this);
		buttonK.setOnClickListener(this);
		buttonL.setOnClickListener(this);
		buttonZ.setOnClickListener(this);
		buttonX.setOnClickListener(this);
		buttonC.setOnClickListener(this);
		buttonV.setOnClickListener(this);
		buttonB.setOnClickListener(this);
		buttonN.setOnClickListener(this);
		buttonM.setOnClickListener(this);
		buttonQ.setOnClickListener(this);
		buttonW.setOnClickListener(this);

		generateGuesses();

		pos = Integer.valueOf(list.get(counter)).intValue();
		lblWord.setText(words[pos]);
		guess = words[pos];
		// Toast.makeText(null, "answer: " + answers[pos],
		// Toast.LENGTH_SHORT).show();
	}

	public void ShowDialog(String title, String t, boolean isGood) {
		final Dialog dialog = new Dialog(Main.this);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle(title);
		dialog.setCancelable(true);
		TextView text = (TextView) dialog.findViewById(R.id.textTitle);
		text.setText(t);
		int draw = 0;
		if (isGood) {
			draw = r.nextInt(3);
			switch (draw) {
			case 0:
				draw = R.drawable.yes;
				break;
			case 1:
				draw = R.drawable.yes;
				break;
			case 2:
				draw = R.drawable.yes;
				break;
			}
		} else {
			draw = r.nextInt(3);
			switch (draw) {
			case 0:
				draw = R.drawable.no;
				break;
			case 1:
				draw = R.drawable.no;
				break;
			case 2:
				draw = R.drawable.no;
				break;
			}
		}
		ImageView i = (ImageView) dialog.findViewById(R.id.ImageView1);
		i.setImageResource(draw);
		Button button = (Button) dialog.findViewById(R.id.buttonOk);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.cancel();
			}
		});
		dialog.show();
	}

	public void onExitAction(View botton) {
		finish();
	}

	public void onUserLeaveHint() {
		finish();
	}

	public void NewRound() {
		guesses = 0;
		count = 0;
		if (counter < words.length - 1)
			counter++;
		else {
			Collections.shuffle(list);
			counter = 0;
		}
		pos = Integer.valueOf(list.get(counter)).intValue();
		lblWord.setText(words[pos]);
		guess = words[pos];
	}

	public void CheckForCorrectWord() {
		if (guess.equals(answers[pos])) {
			ShowDialog("Esatto!", "Ben fatto! " + guess + " è la parola corretta!", true);
			NewRound();
		} else {
			guesses++;
			if (guesses == 3) {
				if (answers[pos].length() > 5) {
				ShowDialog("Possibilità Esaurite!", "Non hai altre possibilità. Era "
						+ answers[pos], false);
				}
				else
				{
					ShowDialog("Possibilità Esaurite!", "Non hai altre possibilità. La risposta corretta era "
							+ answers[pos], false);
				}
				NewRound();
			} else {
				ShowDialog("Risposta Sbagliata!", "Risposta Errata! Ritenta!", false);
				guess = words[pos];
				lblWord.setText(guess);
			}
		}
	}

	public void onDestroy() {
		super.onDestroy();
		int pid = android.os.Process.myPid();
		android.os.Process.killProcess(pid);
	}

	public void onPause() {
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ButtonE:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replace("_", "E");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonR:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "R");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonT:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "T");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonY:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "Y");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonU:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "U");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonI:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "I");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonO:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "O");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonP:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "P");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonA:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "A");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonS:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "S");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonD:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "D");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonF:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "F");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonG:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "G");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonH:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "H");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonJ:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "J");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonK:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "K");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonL:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "L");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonZ:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "Z");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonX:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "X");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonC:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "C");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonV:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "V");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonB:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "B");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonN:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "N");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonM:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "M");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonQ:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "Q");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		case R.id.ButtonW:
			if (guess.indexOf("_") <= -1)
				CheckForCorrectWord();
			else {
				guess = guess.replaceFirst("_", "W");
				if (guess.indexOf("_") <= -1)
					CheckForCorrectWord();
			}
			lblWord.setText(guess);
			break;
		}
	}
	public void onDetachedFromWindow() {
	    try {
	        super.onDetachedFromWindow();
	    }
	    catch (IllegalArgumentException e) {
	        
	    }
	}
}