package com.example.notetakingappv3;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class NoteRepository
{
    private NoteDAO noteDao;
    private MutableLiveData<List<Note>> allNotes = new MutableLiveData<>();

    public NoteRepository(Application application)
    {
        NoteDataBase dataBase = NoteDataBase.getInstance(application);
        noteDao = dataBase.noteDAO();
    }

     public void insert(Note note)

     {
          new InsertNoteAsyncTask(noteDao).execute(note);
     }

     public void update(Note note)
     {
           new UpdateNoteAsyncTask(noteDao).execute(note);
     }

     public  void delete(Note note)
     {
           new DeleteAllNoteAsyncTask(noteDao).execute((Runnable) note);
     }


     public  void allDelete(Note note )
     {
           new DeleteAllNoteAsyncTask(noteDao).execute();
     }

     public LiveData<List<Note>>getAllNotes()
     {
         return allNotes;
     }


     private
    static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void>
     {
          private    NoteDAO noteDAO;

         public InsertNoteAsyncTask(NoteDAO noteDao) {
             this.noteDAO = noteDAO;
         }

        
         @Override
         protected Void doInBackground(Note... notes) {
              noteDAO.insert(notes[0]);
             return null;
         }
     }


    private
    static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void>
    {
        private    NoteDAO noteDAO;

        public UpdateNoteAsyncTask(NoteDAO noteDao)
        {
            this.noteDAO = noteDAO;
        }


        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.update(notes[0]);
            return null;
        }
    }


    private
    static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void>
    {
        private    NoteDAO noteDAO;

        public DeleteNoteAsyncTask(NoteDAO noteDao)
        {
            this.noteDAO = noteDAO;
        }


        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.delete(notes[0]);
            return null;
        }
    }



    private
    static class DeleteAllNoteAsyncTask extends AsyncTask<Void, Void, Void>
    {
        private    NoteDAO noteDAO;

        public DeleteAllNoteAsyncTask(NoteDAO noteDao)
        {
            this.noteDAO = noteDAO;
        }


        

        @Override
        protected Void doInBackground(Void... voids) {
            noteDAO.deleteAllnotes();
            return null;
        }
    }
}
