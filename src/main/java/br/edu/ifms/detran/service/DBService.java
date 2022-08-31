package br.edu.ifms.detran.service;



import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.model.Carro;
import br.edu.ifms.detran.model.Infracao;
import br.edu.ifms.detran.model.Multa;
import br.edu.ifms.detran.repository.CarroRepository;
import br.edu.ifms.detran.repository.InfracaoRepository;
import br.edu.ifms.detran.repository.MultaRepository;

@Service
public class DBService {

	@Autowired
	private CarroRepository carro;
	
	@Autowired
	private InfracaoRepository infracao;
	
	@Autowired
	private MultaRepository multa;

	public void instantiateTestDatabase() throws ParseException {

		Carro car1 = new  Carro(null, "Fusca", "Volks", "ADS 1227");
		Carro car2 = new  Carro(null, "Civic", "Ronda", "ADS 1228");
		Carro car3 = new  Carro(null, "Etios", "Toyota", "ADS 1229");
		Carro car4 = new  Carro(null, "Compass", "Jeep", "ADS 1230");
		Carro car5 = new  Carro(null, "Sandero", "Renault","ADS 1223");
		
		Infracao i1 = new Infracao(null,"Ultrapassagem na faixa continua", 10, 199.0f);
		Infracao i2 = new Infracao(null,"Faixa amarela", 5, 199.0f);
		Infracao i3 = new Infracao(null,"Velocidade acima do permitido", 7, 199.0f);
		Infracao i4 = new Infracao(null,"Estacionamento proibido", 3, 199.0f);
		Infracao i5 = new Infracao(null,"Faixa de pedestre", 5, 199.0f);
		Infracao i6 = new Infracao(null,"Dirigir com celular", 10, 199.0f);
		Infracao i7 = new Infracao(null,"Sinal vermelho", 10, 199.0f);
		Infracao i8 = new Infracao(null,"Dirigir alcolizado", 10, 199.0f);
		Infracao i9 = new Infracao(null,"Ultrapassagem na faixa continua", 10, 199.0f);
		
		Multa m1 = new Multa(null,"Corumbá", 2022, car2, i2);
		Multa m2 = new Multa(null,"Minas",2021, car4, i1);
		Multa m3 = new Multa(null,"Ladário", 2022, car2, i3);
		Multa m4 = new Multa(null,"Porto Figueira",2021, car5, i4);
		Multa m5 = new Multa(null,"Campo Grande", 2022, car2, i5);
		Multa m6 = new Multa(null,"Miranda",2021, car3, i7);
		Multa m7 = new Multa(null,"Paraná", 2022, car2, i6);
		Multa m8 = new Multa(null,"Porto",2021, car1, i8);
		Multa m9 = new Multa(null,"São Paulo", 2022, car2, i9);
		Multa m10 = new Multa(null,"Rio",2021, car3, i5);
		
		car1.getMultas().addAll(Arrays.asList(m8));
		car2.getMultas().addAll(Arrays.asList(m1,m3,m5,m7,m9));
		car3.getMultas().addAll(Arrays.asList(m6,m10));
		car4.getMultas().addAll(Arrays.asList(m2));
		car5.getMultas().addAll(Arrays.asList(m4));
		
	
		i1.getMultas().addAll(Arrays.asList(m2));
		i2.getMultas().addAll(Arrays.asList(m1));
		i3.getMultas().addAll(Arrays.asList(m3));
		i4.getMultas().addAll(Arrays.asList(m4));
		i5.getMultas().addAll(Arrays.asList(m5, m10));
		i6.getMultas().addAll(Arrays.asList(m7));
		i7.getMultas().addAll(Arrays.asList(m6));
		i8.getMultas().addAll(Arrays.asList(m8));
		i9.getMultas().addAll(Arrays.asList(m9));
		
		
		carro.saveAll(Arrays.asList(car1,car2,car3,car4,car5));
		infracao.saveAll(Arrays.asList(i1,i2,i3,i4,i5,i6,i7,i8,i9));
		multa.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10));
		
	}
}