const si = require('systeminformation');

si.cpu()
  .then(data => {
    console.log('CPU Information:');
    console.log('- manufacturer: ' + data.manufacturer);
    console.log('- brand: ' + data.brand);
    console.log('- speed: ' + data.speed);
    console.log('- cores: ' + data.cores);
    console.log('- physical cores: ' + data.physicalCores);
    console.log('- voltagem: ' +data.voltage);
    console.log('- cache l1: ' + data.cache.l1d);
    console.log('- cache l2: ' + data.cache.l2);
    console.log('- cache l3: ' + data.cache.l3);
    console.log('...');
  })
  .catch(error => console.error(error));

si.cpuTemperature()
  .then(data => {
    console.log('main: ' + data.main);
    console.log('cores: ' + data.cores);
    console.log('max: ' + data.max);
    console.log('chipset: ' + data.chipset);
})
.catch(error => console.error(error));

si.mem()
  .then (data => {
    console.log('total: ' + data.total);
    console.log('disponivel: ' +data.free);
    console.log('memoria ativa:  ' +data.active);
    console.log('buffers:   ' +data.buffers);
  })
  .catch(error => console.error(error));

si.memLayout()
  .then (data => {
    console.log('tamanho (size):  ' +data[0].size);
    console.log('tipo:  ' +data[0].type);
  })
  .catch(error => console.error(error));

si.graphics()
  .then (data => {
    console.log('controllers:  ' +data.controllers);
    console.log('modelo:  ' +data.model);
    console.log('vram:   ' +data.vram);
    console.log('cudacores:  ' +data.cores);
  })
  .catch(error => console.error(error));
si.osInfo()
.then (data => {
  console.log('plata    '  + data.plataform);
  console.log('distro '+ data.distro);
  console.log('versao kernel:  ' +data.kernel);
  console.log('codepage: ' +data.codepage);
  console.log('serial:  ' +data.serial);
  console.log('build:  ' +data.build);
  console.log('uefi:   ' +data.uefi);
})
.catch(error => console.error(error));

si.uuid()
.then (data => {
  console.log('hardware:   ' +data.hardware);
  console.log('mac address:  ' +data.macs);
})
.catch(error => console.error(error));

si.processes()
.then (data => {
  console.log('todos os processos:  ' +data.all);
  console.log('processos bloqueados:   ' +data.blocked);
  console.log('processos hibernados:  ' +data.sleeping);
})
.catch(error => console.error(error));

si.networkInterfaces()
.then (data => {
  console.log('interface:   ' +data[0].iface);
  console.log('interface name:   ' +data[0].ifaceName);
  console.log('ipv4:   ' +data[0].ip4);
})
.catch(error => console.error(error));

si.wifiNetworks()
.then (data => {
  console.log('ssid:   ' +data[0].ssid);
  console.log('frequencia:  ' +data[0].frequency);
})
.catch(error => console.error(error));
