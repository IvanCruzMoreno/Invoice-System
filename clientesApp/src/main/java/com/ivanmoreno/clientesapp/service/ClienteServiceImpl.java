package com.ivanmoreno.clientesapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivanmoreno.clientesapp.model.entity.Cliente;
import com.ivanmoreno.clientesapp.model.entity.Factura;
import com.ivanmoreno.clientesapp.model.entity.Producto;
import com.ivanmoreno.clientesapp.model.entity.Region;
import com.ivanmoreno.clientesapp.model.repository.ClienteRepository;
import com.ivanmoreno.clientesapp.model.repository.FacturaRepository;
import com.ivanmoreno.clientesapp.model.repository.ProductoRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepo;
	private FacturaRepository facturaRepo;
	private ProductoRepository productoRepo;
	
	public ClienteServiceImpl(ClienteRepository clienteRepo, FacturaRepository facturaRepo, ProductoRepository productoRepo) {
		this.clienteRepo = clienteRepo;
		this.facturaRepo = facturaRepo;
		this.productoRepo = productoRepo;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteRepo.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteRepo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllRegiones() {
		return clienteRepo.findAllRegiones();
	}

	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaById(Long id) {
		return facturaRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Factura saveFactura(Factura factura) {
		return facturaRepo.save(factura);
	}

	@Override
	@Transactional
	public void deleteFacturaById(Long id) {
		facturaRepo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findProductoByName(String name) {
		return productoRepo.findByName(name);
	}

}
