import React from "react";
import { render,screen } from "../../__test__/test-utils";
import BookingData from "./BookingData";

describe("render content", () => {
    it("el componente se renderiza",()=>{
        const component = render(<BookingData />);
        expect(component).toBeDefined();
    })
    it("se encuentra hora de regreso",()=>{
        const component = render(<BookingData />);
        const ArriveHour = component.queryByText("Hora de Regreso: 07:00")
        expect(ArriveHour).toBeDefined();
    })
    it("se encunetra hora de llegada",()=>{
        const component = render(<BookingData />);
        const ArriveHour = component.queryByText("Hora de Llegada: 18:00")
        expect(ArriveHour).toBeDefined();
    })
});