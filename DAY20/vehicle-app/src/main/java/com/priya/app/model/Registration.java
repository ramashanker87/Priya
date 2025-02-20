package com.priya.app.model;

   public class Registration {
      private Owner vehicleOwner;
        private Vehicle vehicle;

        public Registration(Owner vehicleOwner, Vehicle vehicle) {
            this.vehicleOwner = vehicleOwner;
            this.vehicle = vehicle;
        }

        public Owner getVehicleOwner() {
            return vehicleOwner;
        }
        public void setVehicleOwner(Owner vehicleOwner) {
            this.vehicleOwner = vehicleOwner;
        }
        public Vehicle getVehicle() {
            return vehicle;
        }
        public void setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
        }
    }




