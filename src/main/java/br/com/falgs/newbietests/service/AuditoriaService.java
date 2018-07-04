package br.com.falgs.newbietests.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class AuditoriaService {

	public void registerLog(Logger logger, Object obj) {
		logger.info("Registrando auditoria em log {}", obj);
	}
}
