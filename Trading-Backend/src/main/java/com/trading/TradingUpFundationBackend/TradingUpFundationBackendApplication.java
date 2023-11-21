package com.trading.TradingUpFundationBackend;

import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;
import com.trading.TradingUpFundationBackend.components.NewIdEntitiesWithFiles;
import com.trading.TradingUpFundationBackend.repository.IUserTradingRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TradingUpFundationBackendApplication {

	private final IUserTradingRepository repository;
	private final NewIdEntitiesWithFiles idLogic;

	public TradingUpFundationBackendApplication(IUserTradingRepository repository, NewIdEntitiesWithFiles idLogic){
		this.repository = repository;
		this.idLogic = idLogic;
	}
	public static void main(String[] args) {
		SpringApplication.run(TradingUpFundationBackendApplication.class, args);
	}

	@PostConstruct
	public void run(){
		Integer idNew = 0;
		List<UserTradingEntity> userList = this.repository.findAll();
		UserTradingEntity newAdmin = new UserTradingEntity();
		if(userList.isEmpty()){
			newAdmin.setId(idNew + 1);
			newAdmin.setName("administrador");
			newAdmin.setEmail("admin@gmail.com");
			newAdmin.setPassword("password");
			newAdmin.setUserLevel(4);
			newAdmin.setStatus(true);
			newAdmin.setBacktesting("backtesting account");
			newAdmin.setAuditedAccount("audited account");
			newAdmin.setUserRole("admin");
			this.repository.save(newAdmin);
		} else {
			List<Integer> userIds = new ArrayList<>();
			for(UserTradingEntity entity : userList){
				userIds.add(entity.getId());
				if(!entity.getUserRole().equals("admin")){
					newAdmin.setId(this.idLogic.getHigherNumber(userIds) + 1);
					newAdmin.setName("administrador");
					newAdmin.setEmail("admin@gmail.com");
					newAdmin.setPassword("password");
					newAdmin.setUserLevel(4);
					newAdmin.setStatus(true);
					newAdmin.setBacktesting("backtesting account");
					newAdmin.setAuditedAccount("audited account");
					newAdmin.setUserRole("admin");
					this.repository.save(newAdmin);
				}
			}
		}
	}
}
