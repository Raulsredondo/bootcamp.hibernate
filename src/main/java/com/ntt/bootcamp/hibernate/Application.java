package com.ntt.bootcamp.hibernate;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ntt.bootcamp.hibernate.bdd.Cliente;
import com.ntt.bootcamp.hibernate.bdd.Player;
import com.ntt.bootcamp.hibernate.service.*;



@SpringBootApplication

public class Application implements CommandLineRunner {
	@Autowired 
	private ClienteService clienteService;
	@Autowired
	private PlayerService playerService;
	

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Iniciando sesion.");
		
		//Creamos un jugador
		Player player1 = new Player();
		player1.setName("Cristiano");
		player1.setLastName("Ronaldo");
		player1.setNumber(7);
		player1.setPlayerTeam("Man United");
		
		// Lo guardamos en bdd
		playerService.insertNewPlayer(player1);
		
		//Creamos un jugador
		Player player2 = new Player();
		player2.setName("Lionel");
		player2.setLastName("Messi");
		player2.setNumber(30);
		player2.setPlayerTeam("PSG");
				
		// Lo guardamos en bdd
		playerService.insertNewPlayer(player2);

		Player player3 = new Player();
		player3.setName("Ianis");
		player3.setLastName("Hagi");
		player3.setNumber(10);
		player3.setPlayerTeam("Fiorentina");
				
		// Lo guardamos en bdd
		playerService.insertNewPlayer(player3);
		
		
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Raul");
		cliente1.setSegundoApellido("Redondo");
		cliente1.setPrimerApellido("Sanchez");
		cliente1.setDNI("12345678k");
		
		clienteService.insertCliente(cliente1);
		
		Cliente cliente2 =new Cliente();
		cliente2.setNombre("antonio");
		cliente2.setSegundoApellido("rofriguez");
		cliente2.setPrimerApellido("sanchez");
		cliente2.setDNI("12345678y");
		
		clienteService.insertCliente(cliente2);
		
		Cliente cliente3 =new Cliente();
		cliente3.setNombre("Manuel");
		cliente3.setSegundoApellido("Fernandez");
		cliente3.setPrimerApellido("Gutierrez");
		cliente3.setDNI("12345678p");
		
		clienteService.insertCliente(cliente3);
		
		Cliente cliente4 =new Cliente();
		cliente4.setNombre("Raul");
		cliente4.setSegundoApellido("Fernandez");
		cliente4.setPrimerApellido("Sanchez");
		cliente4.setDNI("12345678h");
		
		clienteService.insertCliente(cliente4);
		
		
		
		
		
		System.out.print("Acabamos de insertar dos Clientes, compruebalo en la base de datos \n");
		
		Scanner waitForKeypress = new Scanner(System.in);
		System.out.print("Presiona la tecla Enter para actualizar el nombre de el cliente(ID 4) Raul por Juan");
		waitForKeypress.nextLine();
	
		
		
		
		cliente1.setSegundoApellido("Juan");
		clienteService.updateCliente(cliente1);
		System.out.println("Nombre: "+cliente1.getNombre() + "\nPrimer Apellido: " + cliente1.getPrimerApellido() + "\nSegundo Apellido: " + cliente1.getSegundoApellido() + "\nDNI: " + cliente1.getDNI()+ "\n");
		
		
		System.out.print("Presiona la tecla Enter para buscar el cliente por el ID 5");
		waitForKeypress.nextLine();
		
		Cliente searchCliente = clienteService.searchByIdCliente(5L);
		System.out.println("Nombre: "+searchCliente.getNombre() + "\nPrimer Apellido: " + searchCliente.getPrimerApellido() + "\nSegundo Apellido: " + searchCliente.getSegundoApellido() + "\nDNI: " + searchCliente.getDNI()+ "\n");

		System.out.print("Presiona la tecla Enter para buscar todos los registros de la tabla");
		waitForKeypress.nextLine();
		
		List<Cliente> clientes = clienteService.findAllCliente();
		prueba(clientes);
		
		
		System.out.print("Presiona la tecla Enter para buscar todos los registros que el valor de el nombre sea Raul y El de el apellido sea Sanchez");
		waitForKeypress.nextLine();
		List<Cliente> clientes2 = clienteService.findByNameYApellido("Raul", "Sanchez");
		prueba(clientes2);
		
		
		System.out.print("Presiona la tecla Enter para eliminar el registro de la base de datos con ID 5");
		waitForKeypress.nextLine();
		clienteService.deleteByIdCliente(searchCliente);
		List<Cliente> clientes3 = clienteService.findAllCliente();
		prueba(clientes3);
		
	
		
		
		Player searchPlayer = playerService.searchById(3L);
		System.out.println("El jugador se llama " + searchPlayer.getName() + " " + searchPlayer.getLastName() + ".");
	}

	@Override
	public String toString() {
		return "Application [playerService=" + playerService + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}		
	public void prueba(List<Cliente> listaclientes) {
		
		System.out.println("Esta es la lista de todos los Clientes \n");
		
		for( Cliente cliente : listaclientes) {
			
		     //code here
			System.out.println("Nombre: "+cliente.getNombre() + "\nPrimer Apellido: " + cliente.getPrimerApellido() + "\nSegundo Apellido: " + cliente.getSegundoApellido() + "\nDNI: " + cliente.getDNI()+ "\n");
		}
				
		
	}

}