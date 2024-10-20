package org.example.trabajofinalfinanzasbackend.repositories;


import org.example.trabajofinalfinanzasbackend.model.OperacionFactoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperacionFactoringRepository extends JpaRepository<OperacionFactoring, Integer> {
@Query(value = "select ofc.*\n" +
        "from factura fc\n" +
        "join operacionfactoring ofc on ofc.id_factura=fc.id\n" +
        "where fc.id=:id;",nativeQuery = true)
OperacionFactoring operacionFactura(@Param("id")Integer id);

@Query(value = "select ofc.*\n" +
        "from factura fc\n" +
        "join operacionfactoring ofc on ofc.id_factura=fc.id\n" +
        "where fc.ruc_cliente_proveedor=:ruc;",nativeQuery = true)
List<OperacionFactoring> operacionesCliente(@Param("ruc") String ruc);

@Query(value = "select ofc.*\n" +
        "from factura fc\n" +
        "join operacionfactoring ofc on ofc.id_factura=fc.id\n" +
        "where fc.ruc_cliente_proveedor=:ruc",nativeQuery = true )
List<OperacionFactoring>  operacionFaactoringsFecha (@Param("ruc")String ruc);


}
