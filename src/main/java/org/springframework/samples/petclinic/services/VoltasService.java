package org.springframework.samples.petclinic.services;

import org.springframework.samples.petclinic.model.Piloto;
import org.springframework.samples.petclinic.model.Volta;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VoltasService {

	public List<Volta> retornarVoltas(MultipartFile file) throws Exception {
		List<Volta> voltas = new ArrayList<>();
		if (file.getSize() == 0)
			throw new Exception("Arquivo inválido");
		String delimitador = "\t";
		if (file.getContentType().equals("text/csv"))
			delimitador = ";";
		try {
			InputStreamReader isReader = new InputStreamReader(file.getInputStream());
			// Creating a BufferedReader object
			BufferedReader reader = new BufferedReader(isReader);
			StringBuffer sb = new StringBuffer();
			String linha;
			reader.readLine();

			while ((linha = reader.readLine()) != null) {
				voltas.add(retornarVolta(linha, delimitador));
			}

		}
		catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return voltas;
	}

	private Volta retornarVolta(String linha, String delimitador) throws ParseException {
		String[] textoExplodido = linha.split(delimitador);
		if (textoExplodido.length != 5)
			throw new ParseException("Arquivo inválido", 1);

		Volta volta = new Volta();

		volta.setHora(converteTextoParaTimeHora(textoExplodido[0].trim()));
		volta.setPiloto(new Piloto(Integer.parseInt(textoExplodido[1].split("–")[0].trim()),
				textoExplodido[1].split("–")[1].trim()));
		volta.setVolta(Integer.parseInt(textoExplodido[2].trim()));
		volta.setTempoVolta(converteTextoParaTimeMinuto(textoExplodido[3].trim()));
		volta.setVelocidadeMedia(Float.parseFloat(textoExplodido[4].trim().replace(",", ".")));

		return volta;
	}

	private Time converteTextoParaTimeHora(String time) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS"); // if 24 hour
																		// format

		java.util.Date d1 = (Date) format.parse(time);

		return new Time(d1.getTime());
	}

	private Time converteTextoParaTimeMinuto(String time) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("mm:ss.SSS"); // if 24 hour format

		java.util.Date d1 = (Date) format.parse(time);

		return new Time(d1.getTime());
	}

}
