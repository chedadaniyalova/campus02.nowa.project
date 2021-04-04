package at.campus02.nowa;

import at.campus02.nowa.figures.*;

import java.io.PrintStream;
import java.util.Scanner;

public class App  {
    private final Scanner input;
    private final PrintStream output;
    private boolean exit = false;
    private int figureNr;
    private Figure figure;
    protected int size;


    // Konstruktor
    // input wird verwendet um Daten vom Benutzer einzulesen (verwendet scanner)
    // output wird verwendet um Text auf der Konsole auszugeben (verwendet sysout)
    public App(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    //die Gameloop
    public void Run() {
        initialize();
        printState();

        while (!exit) {
            readUserInput();
            updateState();
            printState();
        }
    }

    private void initialize() {
        //TODO: Initialisierungen hier durchführen
    }

    private void readUserInput() {
        //TODO: Alle Eingaben der Benutzer einlesen
        inputFigure();
        inputSize();
    }

    private void updateState() {
        //TODO: Benutzereingaben verarbeiten

        switch (figureNr) {
            case 1:
                figure = new FigureH(size);
                break;
            case 2:
                figure = new FigureL(size);
                break;
            case 3:
                figure = new FigureO(size);
                break;
            case 4:
                figure = new FigureO2(size);
                break;
            case 5:
                figure = new FigureI(size);
                break;
            case 6:
                figure = new FigureMinus(size);
                break;
            case 7:
                exit = true;
                figure = null;
                break;
            default:
                break;
        }
    }

    private void printState() {
        //TODO: Ausgabe des aktuellen Zustands
        if (figure != null) {
            output.println(figure);
        }else if ( exit == true) {
    System.out.println("Goodbye");


        }
    }
    private void inputFigure() {
        // Hier sehen Sie ein Pattern für Benutzereingaben
        // Solange kein gültiger Wert eingegeben wurde, wird die Eingabe wiederholt
        do {
            output.println("Welche Grafik möchten Sie anzeigen (1-6). Oder geben Sie 7 ein um das Programm zu beenden");
            figureNr= input.nextInt();
            if (figureNr < 1 || figureNr > 7) {
                output.println("Dies ist keine gültige Grafik!");
            } else {
                break;
            }
        }
            while (true) ;
        }
    private void inputSize() {
        // Hier sehen Sie ein Pattern für Benutzereingaben
        // Solange kein gültiger Wert eingegeben wurde, wird die Eingabe wiederholt
        do {
            output.println("Bitte wählen Sie eine Größe (1-3)");
            size= input.nextInt();
            if (size < 1 || size > 3) {
                output.println("Dies ist keine gültige Größe!");
            } else {
                break;
            }
        }
        while (true) ;
    }
    }



