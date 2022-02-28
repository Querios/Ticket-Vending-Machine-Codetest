package com.codetest.TicketVendingMachine.Classes.ChangeStored;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeStoredRepository extends JpaRepository<ChangeStored, String> {
}
