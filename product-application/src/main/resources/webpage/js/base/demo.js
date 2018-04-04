/**
 * Created by maze on 17/4/26.
 */
// --- Define Data Store

Ext.define('Employees', {
    extend: 'Ext.data.Store',
    alias: 'store.employees',

    proxy: {
        type: 'ajax',
        url: 'data1.json'
    }
});

Ext.define('PopupForm', {
    extend: 'Ext.form.Panel',
    xtype: 'popupform',
    controller: 'popupform',

    title: 'Update Record',

    width: 300,
    floating: true,
    centered: true,
    modal: true,

    items: [{
        xtype: 'textfield',
        name: 'firstname',
        label: 'First Name',
        bind: '{employee.firstName}'
    }, {
        xtype: 'textfield',
        name: 'lastname',
        label: 'Last Name',
        bind: '{employee.lastName}'

    }, {
        xtype: 'textfield',
        name: 'phonenumber',
        label: 'Phone Number',
        bind: '{employee.phoneNumber}'

    }, {
        xtype: 'selectfield',
        name: 'office',
        label: 'Office Location',
        bind: '{employee.officeLocation}',
        options: [{
            text: "Redwood City, CA",
            value: 'rwcca'
        }, {
            text: "Lawrence, KS",
            value: 'lk'
        }, {
            text: "Frederick, MD",
            value: 'fmd'
        }],
        defaultTabletPickerConfig: {
            height: 200
        }
    }, {
        xtype: 'toolbar',
        docked: 'bottom',
        items: ['->', {
            xtype: 'button',
            text: 'Submit',
            iconCls: 'x-fa fa-check',
            handler: 'submitUpdate'
        }, {
            xtype: 'button',
            text: 'Cancel',
            iconCls: 'x-fa fa-close',
            handler: 'cancelUpdate'
        }]
    }]
});

Ext.define('PopupFormController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.popupform',

    cancelUpdate: function () {
        var view = this.getView(),
            record = view.getRecord();

        view.destroy();
        record.reject();
    },

    submitUpdate: function (me) {
        var view = this.getView(),
            record = view.getRecord();

        view.destroy();
        record.commit();
    }
});

//----------------------------------------------------

Ext.define('MyListViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.listview',

    onPopupForm: function (view, index, item, record) {
        Ext.Viewport.add({
            xtype: 'popupform',
            width: 400,
            record: record,
            viewModel: {
                data: {
                    employee: record
                }
            }
        });
    }
});

Ext.application({
    name: 'Sencha Employee Directory',

    launch: function () {
        Ext.Viewport.add({
            xtype: 'tabpanel',
            controller: 'listview',

            items: [{
                title: 'Employee Directory',
                xtype: 'grid',
                iconCls: 'x-fa fa-users',
                grouped: true,
                listeners: {
                    itemtap: 'onPopupForm'
                },
                store: {
                    type: 'employees',
                    autoLoad: true,
                    sorters: ['firstName', 'lastName', 'officeLocation'],
                    grouper: 'officeLocation'
                },
                columns: [{
                    text: 'First Name',
                    dataIndex: 'firstName',
                    flex: 1
                }, {
                    text: 'Last Name',
                    dataIndex: 'lastName',
                    flex: 1
                }, {
                    text: 'Phone Number',
                    dataIndex: 'phoneNumber',
                    flex: 1
                }]
            }, {
                title: 'About Sencha',
                padding: 20,
                iconCls: 'x-fa fa-info-circle',
                html: '<h1>About Sencha</h1><br/>More than 10,000 customers and 60% of the Fortune 100 rely on Sencha solutions to deliver innovative applications that drive their businesses. With a longstanding commitment to web technologies, Sencha dramatically reduces the cost and complexity of developing and delivering enterprise applications across multiple device types.<br/><br/><h2>Create feature-rich HTML5 applications using JavaScript</h2><br/>Sencha Ext JS is the most comprehensive MVC/MVVM JavaScript framework for building feature-rich, cross-platform web applications targeting desktops, tablets, and smartphones. Ext JS leverages HTML5 features on modern browsers while maintaining compatibility and functionality for legacy browsers.<br/><br/>Ext JS features hundreds of high-performance UI widgets that are meticulously designed to fit the needs of the simplest as well as the most complex web applications. Ext JS templates and layout manager give you full control over your display irrespective of devices and screen sizes. An advanced charting package allows you to visualize large quantities of data. The framework includes a robust data package that can consume data from any backend data source. Ext JS also offers several out-of-the-box themes, and complete theming support that lets you build applications that reflect your brand. It also includes an accessibility package (ARIA) to help with Section 508 compliance.'
            }]
        });
    }
});
