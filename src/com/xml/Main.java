package com.xml;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.xml.model.Shiporder;
import com.xml.model.Shiporder.Shipto;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("Start");
			JAXBContext context = JAXBContext.newInstance(Shiporder.class);
			Shiporder shiporder = new Shiporder();
			Shipto shipto = new Shipto();
			shipto.setName("HCM");
			shipto.setCity("HCM");
			shipto.setCountry("VN");
			shipto.setAddress("24 street");
			
			shiporder.setOrderid("1");
			shiporder.setOrderperson("Nguyen Van A");
			shiporder.setShipto(shipto);
			
			File file = new File("resources/example.xml");
			
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(shiporder, file);
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Shiporder shiporder2 = (Shiporder) unmarshaller.unmarshal(file);
			
			System.out.println(shiporder2.getOrderid());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
