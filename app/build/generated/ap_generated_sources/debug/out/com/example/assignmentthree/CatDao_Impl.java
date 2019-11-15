package com.example.assignmentthree;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CatDao_Impl implements CatDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Cat> __insertionAdapterOfCat;

  public CatDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCat = new EntityInsertionAdapter<Cat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Cat` (`id`,`name`,`description`,`temperament`,`origin`,`wikipedia_url`,`life_span`,`dog_friendly`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Cat value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getTemperament() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTemperament());
        }
        if (value.getOrigin() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOrigin());
        }
        if (value.getWikipedia_url() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getWikipedia_url());
        }
        if (value.getLife_span() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLife_span());
        }
        stmt.bindLong(8, value.getDog_friendly());
      }
    };
  }

  @Override
  public void insert(final List<Cat> cats) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCat.insert(cats);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Cat> getCats() {
    final String _sql = "SELECT * FROM Cat";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfTemperament = CursorUtil.getColumnIndexOrThrow(_cursor, "temperament");
      final int _cursorIndexOfOrigin = CursorUtil.getColumnIndexOrThrow(_cursor, "origin");
      final int _cursorIndexOfWikipediaUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "wikipedia_url");
      final int _cursorIndexOfLifeSpan = CursorUtil.getColumnIndexOrThrow(_cursor, "life_span");
      final int _cursorIndexOfDogFriendly = CursorUtil.getColumnIndexOrThrow(_cursor, "dog_friendly");
      final List<Cat> _result = new ArrayList<Cat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Cat _item;
        _item = new Cat();
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item.setDescription(_tmpDescription);
        final String _tmpTemperament;
        _tmpTemperament = _cursor.getString(_cursorIndexOfTemperament);
        _item.setTemperament(_tmpTemperament);
        final String _tmpOrigin;
        _tmpOrigin = _cursor.getString(_cursorIndexOfOrigin);
        _item.setOrigin(_tmpOrigin);
        final String _tmpWikipedia_url;
        _tmpWikipedia_url = _cursor.getString(_cursorIndexOfWikipediaUrl);
        _item.setWikipedia_url(_tmpWikipedia_url);
        final String _tmpLife_span;
        _tmpLife_span = _cursor.getString(_cursorIndexOfLifeSpan);
        _item.setLife_span(_tmpLife_span);
        final int _tmpDog_friendly;
        _tmpDog_friendly = _cursor.getInt(_cursorIndexOfDogFriendly);
        _item.setDog_friendly(_tmpDog_friendly);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Cat> findCatByName(final String name) {
    final String _sql = "SELECT * FROM Cat WHERE Name LIKE ? || '%' ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfTemperament = CursorUtil.getColumnIndexOrThrow(_cursor, "temperament");
      final int _cursorIndexOfOrigin = CursorUtil.getColumnIndexOrThrow(_cursor, "origin");
      final int _cursorIndexOfWikipediaUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "wikipedia_url");
      final int _cursorIndexOfLifeSpan = CursorUtil.getColumnIndexOrThrow(_cursor, "life_span");
      final int _cursorIndexOfDogFriendly = CursorUtil.getColumnIndexOrThrow(_cursor, "dog_friendly");
      final List<Cat> _result = new ArrayList<Cat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Cat _item;
        _item = new Cat();
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item.setDescription(_tmpDescription);
        final String _tmpTemperament;
        _tmpTemperament = _cursor.getString(_cursorIndexOfTemperament);
        _item.setTemperament(_tmpTemperament);
        final String _tmpOrigin;
        _tmpOrigin = _cursor.getString(_cursorIndexOfOrigin);
        _item.setOrigin(_tmpOrigin);
        final String _tmpWikipedia_url;
        _tmpWikipedia_url = _cursor.getString(_cursorIndexOfWikipediaUrl);
        _item.setWikipedia_url(_tmpWikipedia_url);
        final String _tmpLife_span;
        _tmpLife_span = _cursor.getString(_cursorIndexOfLifeSpan);
        _item.setLife_span(_tmpLife_span);
        final int _tmpDog_friendly;
        _tmpDog_friendly = _cursor.getInt(_cursorIndexOfDogFriendly);
        _item.setDog_friendly(_tmpDog_friendly);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Cat findCat(final String name) {
    final String _sql = "SELECT * FROM Cat WHERE Name LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfTemperament = CursorUtil.getColumnIndexOrThrow(_cursor, "temperament");
      final int _cursorIndexOfOrigin = CursorUtil.getColumnIndexOrThrow(_cursor, "origin");
      final int _cursorIndexOfWikipediaUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "wikipedia_url");
      final int _cursorIndexOfLifeSpan = CursorUtil.getColumnIndexOrThrow(_cursor, "life_span");
      final int _cursorIndexOfDogFriendly = CursorUtil.getColumnIndexOrThrow(_cursor, "dog_friendly");
      final Cat _result;
      if(_cursor.moveToFirst()) {
        _result = new Cat();
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _result.setName(_tmpName);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _result.setDescription(_tmpDescription);
        final String _tmpTemperament;
        _tmpTemperament = _cursor.getString(_cursorIndexOfTemperament);
        _result.setTemperament(_tmpTemperament);
        final String _tmpOrigin;
        _tmpOrigin = _cursor.getString(_cursorIndexOfOrigin);
        _result.setOrigin(_tmpOrigin);
        final String _tmpWikipedia_url;
        _tmpWikipedia_url = _cursor.getString(_cursorIndexOfWikipediaUrl);
        _result.setWikipedia_url(_tmpWikipedia_url);
        final String _tmpLife_span;
        _tmpLife_span = _cursor.getString(_cursorIndexOfLifeSpan);
        _result.setLife_span(_tmpLife_span);
        final int _tmpDog_friendly;
        _tmpDog_friendly = _cursor.getInt(_cursorIndexOfDogFriendly);
        _result.setDog_friendly(_tmpDog_friendly);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
