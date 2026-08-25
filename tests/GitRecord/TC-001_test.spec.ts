import { test, expect } from '@playwright/test';

test(
  'test',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-001' },
    tag: ['@QADENCE_TC_ID:TC-001'],
  },
  async ({ page }) => {


    await test.step('navigate', async () => {
      await page.goto('https://github.com/qadence-ai/rnd-qa');
    });

    await test.step('click', async () => {
      await page.locator("xpath=(//img)[3]").click();
    });

    await test.step('click', async () => {
      await page.locator("xpath=(//img)[4]").click();
    });

    await test.step('click', async () => {
      await page.getByRole("img", { name: "404 “This is not the web page you are looking for”" }).click();
    });

    await test.step('click', async () => {
      await page.locator('div.position-relative').locator('div.position-absolute').locator('img.position-absolute').click();
    });

    await test.step('click', async () => {
      await page.locator("xpath=(//img)[8]").click();
    });

  }
);

