package com.trading.TradingUpFundationBackend;

import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;
import com.trading.TradingUpFundationBackend.components.NewIdEntitiesWithFiles;
import com.trading.TradingUpFundationBackend.repository.IUserTradingRepository;
import com.trading.TradingUpFundationBackend.security.Encryption;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TradingUpFundationBackendApplication {

	private final IUserTradingRepository repository;
	private final NewIdEntitiesWithFiles idLogic;
	private final Encryption encryption;

	public TradingUpFundationBackendApplication(IUserTradingRepository repository, NewIdEntitiesWithFiles idLogic, Encryption encryption) {
		this.repository = repository;
		this.idLogic = idLogic;
		this.encryption = encryption;
	}

	public static void main(String[] args) {
		SpringApplication.run(TradingUpFundationBackendApplication.class, args);
	}

	@PostConstruct
	public void run() {
		List<UserTradingEntity> userList = this.repository.findAll();
		List<Integer> idList = new ArrayList<>();
		for (UserTradingEntity entity : userList) {
			idList.add(entity.getId());
		}
		if (userList.isEmpty()) {
			UserTradingEntity admin = new UserTradingEntity();
			admin.setId(this.idLogic.getHigherNumber(idList) + 1);
			admin.setEmail("admin@gmail.com");
			admin.setPassword(this.encryption.encrypt("password"));
			admin.setUserRole("admin");
			admin.setStatus(true);
			admin.setName("administrador");
			admin.setBacktesting("cuenta de backtesting");
			admin.setAuditedAccount("cuenta auditada");
			admin.setUserLevel(4);
			this.repository.save(admin);
		} else if(thereAreAdmins()){
			System.out.println("Ya hay administradores");
		}
	}

	private boolean thereAreAdmins(){
		List<UserTradingEntity> userList = this.repository.findAll();
		for(UserTradingEntity entity : userList){
			if(entity.getUserRole().equals("admin")){
				return true;
			}
		}
		return false;
	}
}