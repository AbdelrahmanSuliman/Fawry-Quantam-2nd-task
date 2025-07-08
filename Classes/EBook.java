package Classes;

import Enums.FileType;

public class EBook extends Book {
    FileType fileType;

    public EBook(String isbn, String title, int year, double price, FileType fileType) {
        super(isbn, title, year, price);
        this.fileType = fileType;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }
}
