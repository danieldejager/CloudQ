/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.GetRegistrationByUserId;
import disc.tiinfosec.datalayer.GetRegistrationIdFromUsers;
/**
 *
 * @author daniel112
 */
public class GetRegIdFromUsers {
public String ReturnRegistrationIdbyUserName(String p_username)    {
     GetRegistrationIdFromUsers get = new GetRegistrationIdFromUsers();
     return get.GetRegId(p_username);
}
}
