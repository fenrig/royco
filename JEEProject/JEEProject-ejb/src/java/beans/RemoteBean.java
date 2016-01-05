/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.*;

/**
 *
 * @author Roy Scheerens
 */
@Stateless
public class RemoteBean implements RemoteBeanRemote
{
    @EJB
    private localStatelessBeanLocal localStatelessBean;

    @Override
    public String test()
    {
        return Integer.toString(localStatelessBean.getAllLeningen().size());
    }

}
