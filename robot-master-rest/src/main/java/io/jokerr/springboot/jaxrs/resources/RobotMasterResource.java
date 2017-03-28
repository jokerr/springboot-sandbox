package io.jokerr.springboot.jaxrs.resources;

import io.jokerr.springboot.beans.RobotMasterService;
import io.jokerr.springboot.jpa.domain.RobotMaster;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * @author jokerr
 */
@Path("robot-master")
public class RobotMasterResource {

    @Autowired
    private RobotMasterService robotMasterService;

    @GET
    public List<RobotMaster> findRobotMaster(
            @QueryParam("name") String name,
            @QueryParam("weapon") String weapon,
            @QueryParam("end") Double endurance,
            @QueryParam("int") Double intelligence,
            @QueryParam("spd") Double speed,
            @QueryParam("bat") Double battle) {
        return robotMasterService.search(name, weapon, endurance, intelligence, speed, battle);
    }

    @GET
    @Path("{id}")
    public RobotMaster getRobotMaster(@PathParam("id") String id) {
        return robotMasterService.find(id);
    }
}
