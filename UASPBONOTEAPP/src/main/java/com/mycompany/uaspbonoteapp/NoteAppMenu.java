/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uaspbonoteapp;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class NoteAppMenu {
   
    private NoteService noteService;
    private Scanner scanner;

    public NoteAppMenu(String databasePath) {
        noteService = new NoteService(new DatabaseStorage(databasePath));
        scanner = new Scanner(System.in);
    }

    public NoteAppMenu(String notesdb) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void start(){
        addNote();
        showNotes();
    }
    
    private void addNote() {
        System.out.print("Enter note: ");
        if(scanner.hasNextInt()){
            scanner.nextLine();
        }
        String note = scanner.nextLine();
        noteService.createNote(note);
        System.out.println("Note disimpan: " + note);
    }
    
    private void showNotes() {
        List<String> notes = noteService.readNotes();
        System.out.println("Note tersimpan:");
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
        } else {
            for (String note : notes) {
                System.out.println(note);
            }
        }
    }
}

