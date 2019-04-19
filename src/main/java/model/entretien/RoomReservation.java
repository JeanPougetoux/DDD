package model.entretien;

import common.status.RoomReservationStatus;

class RoomReservation {
    private RoomReservationStatus status;
    private Room room;

    RoomReservation(Room room) {
        this.room = room;
        this.status = RoomReservationStatus.PLANIFIED;
    }

    public Room getRoom(){
        return room;
    }

    public void confirm(){
        this.status = RoomReservationStatus.CONFIRMED;
    }

    public void cancel(){
        this.status = RoomReservationStatus.CANCELLED;
    }
}
