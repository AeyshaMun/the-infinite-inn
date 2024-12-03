package main.java.view;

import main.java.interface_adapter.BookRoom.BookRoomViewModel;
import main.java.interface_adapter.BookRoomConfirm.BookRoomConfirmState;
import main.java.interface_adapter.BookRoomConfirm.BookRoomConfirmViewModel;

import javax.swing.*;
import java.awt.*;

public class BookRoomConfirmView extends JPanel {
    private final String viewName = "Book Room Confirmation";

    public String getViewName() {return viewName;}
}
